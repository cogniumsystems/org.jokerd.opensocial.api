/**
 * 
 */
package org.jokerd.opensocial.api.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.ubimix.commons.json.JsonValue;
import org.ubimix.commons.json.JsonValue.IJsonValueFactory;

/**
 * Object-Id is to be an opaque string value that the API will use for resultant
 * data and for queries. Containers MUST support for any query, and valid id
 * that the API returns. Containers MAY support the Global-Id format.
 * 
 * <pre>
 * Object-Id = Local-Id / Global-Id
 * Local-Id = *( ALPHA / DIGIT / "_" / "." / "-" )
 * Global-Id   = Domain-Name ":" Local-Id
 * </pre>
 * 
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/1.1/Core-Data.xml#Object-Id
public class ObjectId {

    public static IJsonValueFactory<ObjectId> FACTORY = new IJsonValueFactory<ObjectId>() {
        @Override
        public ObjectId newValue(Object object) {
            String str = JsonValue.STRING_FACTORY.newValue(object);
            return new ObjectId(str);
        }
    };

    protected static String decode(String str) {
        return LocalIdEncoder.getInstance().decode(str);
    }

    protected static String encode(String str) {
        return LocalIdEncoder.getInstance().encode(str);
    }

    public static <T extends ObjectId> Map<DomainName, Set<T>> groupByDomains(
        Collection<T> ids) {
        Map<DomainName, Set<T>> domainNames = new HashMap<DomainName, Set<T>>();
        for (T id : ids) {
            DomainName domainName = id.getDomainName();
            Set<T> set = domainNames.get(domainName);
            if (set == null) {
                set = new HashSet<T>();
                domainNames.put(domainName, set);
            }
            set.add(id);
        }
        return domainNames;
    }

    private final DomainName fDomainName;

    private final String fLocalId;

    public ObjectId(DomainName domainName, String localId) {
        fDomainName = domainName;
        fLocalId = encode(localId);
    }

    public ObjectId(ObjectId objectId) {
        fDomainName = objectId.fDomainName;
        fLocalId = objectId.fLocalId;
    }

    public ObjectId(String id) {
        int idx = id.lastIndexOf(':');
        if (idx > 0) {
            fDomainName = new DomainName(id.substring(0, idx));
            fLocalId = id.substring(idx + 1);
        } else {
            fDomainName = null;
            fLocalId = id;
        }
    }

    public ObjectId(String domainName, String localId) {
        this(new DomainName(domainName), localId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ObjectId)) {
            return false;
        }
        ObjectId o = (ObjectId) obj;
        return equals(fDomainName, o.fDomainName)
            && equals(fLocalId, o.fLocalId);
    }

    private boolean equals(Object first, Object second) {
        return first == null || second == null ? first == second : first
            .equals(second);
    }

    public DomainName getDomainName() {
        return fDomainName;
    }

    public String getLocalId() {
        return fLocalId;
    }

    public String getLocalIdDecoded() {
        return decode(fLocalId);
    }

    @Override
    public int hashCode() {
        int a = fDomainName != null ? fDomainName.hashCode() : 0;
        int b = fLocalId.hashCode();
        return a ^ b;
    }

    @Override
    public String toString() {
        if (fDomainName == null) {
            return fLocalId;
        }
        return fDomainName + ":" + fLocalId;
    }
}

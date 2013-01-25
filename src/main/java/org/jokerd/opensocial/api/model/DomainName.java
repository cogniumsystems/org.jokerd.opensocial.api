/**
 * 
 */
package org.jokerd.opensocial.api.model;

import org.ubimix.commons.json.JsonValue;
import org.ubimix.commons.json.JsonValue.IJsonValueFactory;

/**
 * The Domain-Name is an optional data type that containers may use to uniquely
 * identify themselves. It is recommended that they use a registered domain name
 * where possible.
 * 
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/1.1/Core-Data.xml#Domain-Name
public class DomainName {

    public static final IJsonValueFactory<DomainName> FACTORY = new IJsonValueFactory<DomainName>() {
        @Override
        public DomainName newValue(Object object) {
            String str = JsonValue.STRING_FACTORY.newValue(object);
            return new DomainName(str);
        }
    };

    protected final String fDomainName;

    public DomainName(DomainName domainName) {
        fDomainName = domainName != null ? domainName.fDomainName : null;
    }

    /**
     * @param domainName
     */
    public DomainName(String domainName) {
        fDomainName = LocalIdEncoder.getInstance().encode(domainName);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DomainName)) {
            return false;
        }
        DomainName o = (DomainName) obj;
        return fDomainName.equals(o.fDomainName);
    }

    protected final String getDomainName() {
        return fDomainName;
    }

    protected final String getDomainNameDecoded() {
        return LocalIdEncoder.getInstance().decode(fDomainName);
    }

    @Override
    public final int hashCode() {
        return fDomainName.hashCode();
    }

    @Override
    public final String toString() {
        return fDomainName;
    }

}

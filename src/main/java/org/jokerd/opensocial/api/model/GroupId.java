/**
 * 
 */
package org.jokerd.opensocial.api.model;

import org.ubimix.commons.json.JsonValue;
import org.ubimix.commons.json.JsonValue.IJsonValueFactory;

/**
 * @author kotelnikov
 */
public class GroupId extends ObjectId {

    public final static GroupId ALL = new GroupId("@all");

    public static IJsonValueFactory<GroupId> FACTORY = new IJsonValueFactory<GroupId>() {
        public GroupId newValue(Object object) {
            String str = JsonValue.STRING_FACTORY.newValue(object);
            return new GroupId(str);
        }
    };

    public final static GroupId FRIENDS = new GroupId("@friends");

    public final static GroupId SELF = new GroupId("@self");

    public GroupId(DomainName domainName, String localId) {
        super(domainName, localId);
    }

    public GroupId(ObjectId objectId) {
        super(objectId);
    }

    public GroupId(String id) {
        super(id);
    }

}

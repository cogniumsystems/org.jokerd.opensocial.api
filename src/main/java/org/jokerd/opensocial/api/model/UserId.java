/**
 * 
 */
package org.jokerd.opensocial.api.model;

import org.ubimix.commons.json.JsonValue;
import org.ubimix.commons.json.JsonValue.IJsonValueFactory;

/**
 * A User-Id uses the same format as an Object-Id, but there are several
 * reserved values for common cases.
 * 
 * <pre>
 * User-Id = Object-Id / "@owner" / "@viewer" / "@me"
 * </pre>
 * 
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/1.1/Core-Data.xml#User-Id
public class UserId extends ObjectId {

    public static IJsonValueFactory<UserId> FACTORY = new IJsonValueFactory<UserId>() {
        @Override
        public UserId newValue(Object object) {
            String str = JsonValue.STRING_FACTORY.newValue(object);
            return new UserId(str);
        }
    };

    /**
     * The currently authenticated user. For example, when an API request is
     * received the user who's credentials are included in the authorization
     * header of the request can be referenced as '@me'.
     */
    public final static UserId ME = new UserId("@me");

    /**
     * The user that owns the current page. For example, if Alice is viewing
     * Bob's profile page, then Bob is the owner.
     */
    public final static UserId OWNER = new UserId("@owner ");

    /**
     * The user than is logged in an viewing the current page. For example, if
     * Alice is viewing Bob's profile page, then Alice is the viewer.
     */
    public final static UserId VIEWER = new UserId("@viewer");

    public UserId(DomainName domainName, String localId) {
        super(domainName, localId);
    }

    public UserId(ObjectId objectId) {
        super(objectId);
    }

    public UserId(String id) {
        super(id);
    }

}

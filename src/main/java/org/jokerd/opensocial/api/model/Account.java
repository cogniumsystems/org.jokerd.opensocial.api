package org.jokerd.opensocial.api.model;

/**
 * Describes an account held by this Person, which MAY be on the Service
 * Provider's service, or MAY be on a different service. Consumers SHOULD NOT
 * assume that this account has been verified by the Service Provider to
 * actually belong to this Person. For each account, the domain is the top-most
 * authoritative domain for this account, e.g. yahoo.com or reader.google.com,
 * and MUST be non-empty. Each account must also contain a non-empty value for
 * either username or userId, and MAY contain both, in which case the two values
 * MUST be for the same account. These accounts can be used to determine if a
 * user on one service is also known to be the same person on a different
 * service, to facilitate connecting to people the user already knows on
 * different services. If Consumers want to turn these accounts into profile
 * URLs, they can use an open-source library like [Social-Graph-Node-Mapper].
 * 
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/2.0.1/Social-Data.xml#Account
public class Account extends DataObject {

    public static IJsonValueFactory<Account> FACTORY = new IJsonValueFactory<Account>() {
        public Account newValue(Object object) {
            return new Account().setJsonObject(object);
        }
    };

    /**
     * The top-most authoritative domain for this account, e.g. "twitter.com".
     * This is the Primary Sub-Field for this field, for the purposes of sorting
     * and filtering.
     */
    public DomainName getDomain() {
        return getValue("domain", DomainName.FACTORY);
    }

    /** A user ID associated with this account. */
    public UserId getUserId() {
        UserId userId = getValue("userId", UserId.FACTORY);
        if (userId == null || userId.getDomainName() == null) {
            DomainName domain = getDomain();
            String localId = userId != null ? userId.getLocalId() : null;
            if (localId == null) {
                localId = getUsername();
            }
            userId = new UserId(domain, localId);
        }
        return userId;
    }

    /** A user ID associated with this account. */
    public String getUserIdAsString() {
        return getString("userId");
    }

    /** An alphanumeric user name, usually chosen by the user, e.g. "jsmarr". */
    public String getUsername() {
        return getString("username");
    }

    /**
     * The top-most authoritative domain for this account, e.g. "twitter.com".
     * This is the Primary Sub-Field for this field, for the purposes of sorting
     * and filtering.
     */
    public Account setDomain(DomainName value) {
        setValue("domain", value);
        return this;
    }

    /**
     * The top-most authoritative domain for this account, e.g. "twitter.com".
     * This is the Primary Sub-Field for this field, for the purposes of sorting
     * and filtering.
     */
    public Account setDomain(String value) {
        return setDomain(new DomainName(value));
    }

    public void setFullUserId(ObjectId value) {
        setDomain(value.getDomainName());
        setUserId(value.getLocalId());
    }

    /** A user ID associated with this account. */
    public Account setUserId(String value) {
        setValue("userId", value);
        return this;
    }

    /** An alphanumeric user name, usually chosen by the user, e.g. "jsmarr". */
    public Account setUsername(String value) {
        setValue("username", value);
        return this;
    }

}
package org.jokerd.opensocial.api.model.ext;

import org.jokerd.opensocial.api.model.DataObject;
import org.jokerd.opensocial.api.model.DomainName;

/**
 * Instances of this type are used as containers of information about Social
 * Networks.
 * 
 * @author kotelnikov
 */
public class SocialNetwork extends DataObject {

    public static IJsonValueFactory<SocialNetwork> FACTORY = new IJsonValueFactory<SocialNetwork>() {
        public SocialNetwork newValue(Object object) {
            return new SocialNetwork().setJsonObject(object);
        }
    };

    public SocialNetwork() {
        super();
    }

    public SocialNetwork(DomainName domain) {
        super();
        setDomain(domain);
    }

    public SocialNetwork(String domain) {
        this(new DomainName(domain));
    }

    /**
     * Returns the domain corresponding to this Social Network.
     * 
     * @return the domain corresponding to this Social Network
     */
    public DomainName getDomain() {
        return getObject("domain", DomainName.FACTORY);
    }

    /**
     * Returns a full URL of an icon for this social network
     * 
     * @return a full URL of an icon for this social network
     */
    public String getIconUrl() {
        return getString("iconUrl");
    }

    /**
     * Returns a human-readable namd of this network.
     * 
     * @return a human-readable name of this network
     */
    public String getName() {
        return getString("name");
    }

    /**
     * Returns "coordinates" of OAuth endpoint for this social network.
     * 
     * @return OAuth "coordinates" of this social network
     */
    public OAuthInfo getOAuthInfo() {
        return getObject("oauth", OAuthInfo.FACTORY);
    }

    /**
     * Returns an URL of a small icon corresponding to this network.
     * 
     * @return an URL of a small icon corresponding to this network
     */
    public String getSmallIconUrl() {
        return getString("smallIconUrl");
    }

    /**
     * Sets a new domain of the name for this social network.
     * 
     * @param value the new value to set
     * @return the reference to this instance
     */
    public SocialNetwork setDomain(DomainName value) {
        setValue("domain", value);
        return this;
    }

    /**
     * Sets a new URL of a small icon corresponding to this network.
     * 
     * @param value the new value to set
     * @return the reference to this instance
     */
    public SocialNetwork setIconUrl(String value) {
        setValue("iconUrl", value);
        return this;
    }

    /**
     * Sets a new value of the name for this social network.
     * 
     * @param value the new value to set
     * @return the reference to this instance
     */
    public SocialNetwork setName(String value) {
        setValue("name", value);
        return this;
    }

    /**
     * Sets new "coordinates" of OAuth endpoint for this social network.
     */
    public SocialNetwork setOAuthInfo(OAuthInfo oauth) {
        setValue("oauth", oauth);
        return this;
    }

    /**
     * Sets a new URL of a small icon corresponding to this network.
     * 
     * @param value the new value to set
     * @return the reference to this instance
     */
    public SocialNetwork setSmallIconUrl(String value) {
        setValue("smallIconUrl", value);
        return this;
    }

}
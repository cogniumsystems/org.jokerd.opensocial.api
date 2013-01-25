/**
 * 
 */
package org.jokerd.opensocial.api.model.ext;

import org.jokerd.opensocial.api.model.DataObject;

/**
 * @author kotelnikov
 */
public class OAuthInfo extends DataObject {

    public static IJsonValueFactory<OAuthInfo> FACTORY = new IJsonValueFactory<OAuthInfo>() {
        @Override
        public OAuthInfo newValue(Object object) {
            return new OAuthInfo().setJsonObject(object);
        }
    };

    /**
     * 
     */
    public OAuthInfo() {
    }

    /**
     * @param object
     */
    public OAuthInfo(Object object) {
        super(object);
    }

    public void clearAccessInfo() {
        removeValue("accessToken");
        removeValue("accessSecret");
    }

    public String getAccessSecret() {
        return getString("accessSecret");
    }

    public String getAccessToken() {
        return getString("accessToken");
    }

    public String getAccessTokenURL() {
        return getString("accessTokenURL");
    }

    public String getCallbackUrl() {
        return getString("callbackUrl");
    }

    public String getConsumerKey() {
        return getString("consumerKey");
    }

    public String getConsumerSecret() {
        return getString("consumerSecret");
    }

    public String getRequestSecret() {
        return getString("requestSecret");
    }

    public String getRequestToken() {
        return getString("requestToken");
    }

    public String getRequestTokenURL() {
        return getString("requestTokenURL");
    }

    public String getUserAuthorizationURL() {
        return getString("userAuthorizationURL");
    }

    public boolean isAuthorized() {
        String token = getAccessToken();
        return token != null && !"".equals(token);
    }

    public OAuthInfo setAccessInfo(String token, String secret) {
        setValue("accessToken", token);
        setValue("accessSecret", secret);
        return this;
    }

    public OAuthInfo setAccessSecret(String value) {
        setValue("accessSecret", value);
        return this;
    }

    public OAuthInfo setAccessTokenURL(String value) {
        setValue("accessTokenURL", value);
        return this;
    }

    public OAuthInfo setCallbackUrl(String value) {
        setValue("callbackUrl", value);
        return this;
    }

    public OAuthInfo setConsumerKey(String value) {
        setValue("consumerKey", value);
        return this;
    }

    public OAuthInfo setConsumerSecret(String value) {
        setValue("consumerSecret", value);
        return this;
    }

    public OAuthInfo setRequestInfo(String token, String secret) {
        setValue("requestToken", token);
        setValue("requestSecret", secret);
        return this;
    }

    public OAuthInfo setRequestToken(String value) {
        setValue("requestToken", value);
        return this;
    }

    public OAuthInfo setRequestTokenURL(String value) {
        setValue("requestTokenURL", value);
        return this;
    }

    public OAuthInfo setUserAuthorizationURL(String value) {
        setValue("userAuthorizationURL", value);
        return this;
    }

}

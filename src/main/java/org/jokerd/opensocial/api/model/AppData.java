package org.jokerd.opensocial.api.model;

/**
 * OpenSocial defines a data store that applications can use to read and write
 * user-specific data. This data store can be read by anyone who can see the
 * gadget, but only the VIEWER's data is writable. The keys that developers
 * specify to index this data must only contain alphanumeric (A-Za-z0-9)
 * characters, underscore(_), dot(.) or dash(-). Since application data is often
 * created based on user inputs, OpenSocial containers perform automatic HTML
 * escaping of all application data. However, developers have the option of
 * turning off this escaping by setting the escapeType parameter on
 * newFetchPersonAppData and getField calls. Because of the potential for abuse,
 * containers MAY implement quotas or rate limits to preserve their disk space.
 * 
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/2.0.1/Social-Data.xml#AppData
public class AppData extends DataObject {

    public static IJsonValueFactory<AppData> FACTORY = new IJsonValueFactory<AppData>() {
        public AppData newValue(Object object) {
            return new AppData().setJsonObject(object);
        }
    };

    /**
     * A unique value with respect to the context it is being stored within
     * (typically a person).
     */
    public String getKey() {
        return getString("key");
    }

    /**
     * An arbitary string.
     */
    public String getValue() {
        return getString("value");
    }

    /**
     * A unique value with respect to the context it is being stored within
     * (typically a person).
     */
    public void setKey(String key) {
        setValue("key", key);
    }

    /**
     * An arbitary string.
     */
    public void setValue(String value) {
        setValue("value", value);
    }

}

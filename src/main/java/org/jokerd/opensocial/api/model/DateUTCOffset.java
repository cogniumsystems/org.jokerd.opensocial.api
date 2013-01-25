/**
 * 
 */
package org.jokerd.opensocial.api.model;

import org.ubimix.commons.json.JsonValue;
import org.ubimix.commons.json.JsonValue.IJsonValueFactory;

/**
 * See: XML Schema dateTime format, offset portion [XSdateTime]. Example: -08:00
 * 
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/2.0.1/Core-Data.xml#Date-UTC-Offset
// http://opensocial-resources.googlecode.com/svn/spec/2.0.1/Core-Data.xml#XSdateTime
public class DateUTCOffset {

    public static IJsonValueFactory<DateUTCOffset> FACTORY = new IJsonValueFactory<DateUTCOffset>() {
        @Override
        public DateUTCOffset newValue(Object object) {
            String str = JsonValue.STRING_FACTORY.newValue(object);
            return new DateUTCOffset(str);
        }
    };

    private final String fValue;

    public DateUTCOffset(DateUTCOffset offset) {
        fValue = offset.fValue;
    }

    public DateUTCOffset(String str) {
        fValue = str;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateUTCOffset)) {
            return false;
        }
        DateUTCOffset o = (DateUTCOffset) obj;
        return equals(fValue, o.fValue);
    }

    private boolean equals(Object first, Object second) {
        return first == null || second == null ? first == second : first
            .equals(second);
    }

    @Override
    public int hashCode() {
        return fValue.hashCode();
    }

    @Override
    public String toString() {
        return fValue;
    }
}

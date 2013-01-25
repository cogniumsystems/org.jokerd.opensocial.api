/**
 * 
 */
package org.jokerd.opensocial.api.model.ext;

import org.ubimix.commons.json.JsonValue;
import org.ubimix.commons.json.JsonValue.IJsonValueFactory;

/**
 * @author kotelnikov
 */
public class Tag implements Comparable<Tag> {

    public static IJsonValueFactory<Tag> FACTORY = new IJsonValueFactory<Tag>() {
        @Override
        public Tag newValue(Object object) {
            String str = JsonValue.STRING_FACTORY.newValue(object);
            return new Tag(str);
        }
    };

    protected final String fTag;

    /**
     * @param reference
     */
    public Tag(String reference) {
        fTag = reference;
    }

    @Override
    public final int compareTo(Tag o) {
        return fTag.compareTo(o.fTag);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag o = (Tag) obj;
        return fTag.equals(o.fTag);
    }

    @Override
    public final int hashCode() {
        return fTag.hashCode();
    }

    @Override
    public final String toString() {
        return fTag;
    }

}

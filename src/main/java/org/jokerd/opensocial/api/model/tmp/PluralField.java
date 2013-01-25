/**
 * 
 */
package org.jokerd.opensocial.api.model.tmp;

import java.util.List;

import org.jokerd.opensocial.api.model.DataObject;

/**
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/2.0.1/Core-Data.xml#Plural-Field
public interface PluralField<E> extends List<PluralField.Value> {

    public static class Value extends DataObject {

        /**
         * A Boolean value indicating whether this instance of the Plural Field
         * is the primary or preferred value of for this field, e.g. the
         * preferred mailing address or primary e-mail address. Service
         * Providers MUST NOT mark more than one instance of the same Plural
         * Field as primary="true", and MAY choose not to mark any fields as
         * primary, if this information is not available. For efficiency,
         * Service Providers SHOULD NOT mark all non-primary fields with
         * primary="false", but should instead omit this sub-field for all
         * non-primary instances.
         */
        public boolean getPrimary() {
            return getBoolean("primary", false);
        }

        /**
         * The type of field for this instance, usually used to label the
         * preferred function of the given contact information. Unless otherwise
         * specified, this string value specifies Canonical Values of work,
         * home, and other.
         */
        public String getType() {
            return getString("type");
        }

        /**
         * The primary value of this field, e.g. the actual e-mail address,
         * phone number, or URL. When specifying a sortBy field in the Query
         * Parameters for a Plural Field, the default meaning is to sort based
         * on this value sub-field. Each non-empty Plural Field value MUST
         * contain at least the value sub-field, but all other sub-fields are
         * optional.
         */
        public <E> E getValue(IJsonValueFactory<E> factory) {
            return getValue("value", factory);
        }

    }

    /**
     * The type of field for this instance, usually used to label the preferred
     * function of the given contact information. Unless otherwise specified,
     * this string value specifies Canonical Values of work, home, and other.
     */
    String getType();

    /**
     * The primary value of this field, e.g. the actual e-mail address, phone
     * number, or URL. When specifying a sortBy field in the Query Parameters
     * for a Plural Field, the default meaning is to sort based on this value
     * sub-field. Each non-empty Plural Field value MUST contain at least the
     * value sub-field, but all other sub-fields are optional.
     */
    E getValue();

    /**
     * A Boolean value indicating whether this instance of the Plural Field is
     * the primary or preferred value of for this field, e.g. the preferred
     * mailing address or primary e-mail address. Service Providers MUST NOT
     * mark more than one instance of the same Plural Field as primary="true",
     * and MAY choose not to mark any fields as primary, if this information is
     * not available. For efficiency, Service Providers SHOULD NOT mark all
     * non-primary fields with primary="false", but should instead omit this
     * sub-field for all non-primary instances.
     */
    boolean isPrimary();

}

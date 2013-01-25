package org.jokerd.opensocial.api.model;

/**
 * The components of a physical mailing address. Service Providers MAY return
 * just the full address as a single string in the formattedsub-field, or they
 * MAY return just the individual component fields using the other sub-fields,
 * or they MAY return both. If both variants are returned, they SHOULD be
 * describing the same address, with the formatted address indicating how the
 * component fields should be combined.
 * 
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/2.0.1/Social-Data.xml#Address
public class Address extends DataObject {

    public static IJsonValueFactory<Address> FACTORY = new IJsonValueFactory<Address>() {
        public Address newValue(Object object) {
            return new Address().setJsonObject(object);
        }
    };

    /**
     * The building identifier. Discussion [Issue-1132]
     */
    public String getBuilding() {
        return getString("building");
    }

    /**
     * The country name component.
     */
    public String getCountry() {
        return getString("country");
    }

    /**
     * The floor identifier. Discussion [Issue-1132]
     */
    public String getFloor() {
        return getString("floor");
    }

    /**
     * The full mailing address, formatted for display or use with a mailing
     * label. This field MAY contain newlines. This is the Primary Sub-Field for
     * this field, for the purposes of sorting and filtering.
     */
    public String getFormatted() {
        return getString("formatted");
    }

    /**
     * Expresses the latitude of the location on a map.
     */
    public String getLatitude() {
        return getString("latitude");
    }

    /**
     * The city or locality component.
     */
    public String getLocality() {
        return getString("locality");
    }

    /**
     * Expresses the longitude of the location on a map.
     */
    public String getLongitude() {
        return getString("longitude");
    }

    /**
     * The zipcode or postal code component.
     */
    public String getPostalCode() {
        return getString("postalCode");
    }

    /**
     * The state or region component.
     */
    public String getRegion() {
        return getString("region");
    }

    /**
     * The full street address component, which may include house number, street
     * name, PO BOX, and multi-line extended street address information. This
     * field MAY contain newlines.
     */
    public String getStreetAddress() {
        return getString("streetAddress");
    }

    /**
     * The address type or label. Examples include 'work', 'home'.
     */
    public String getType() {
        return getString("type");
    }

    /**
     * The building identifier. Discussion [Issue-1132]
     */
    public Address setBuilding(String value) {
        setValue("building", value);
        return this;
    }

    /**
     * The country name component.
     */
    public Address setCountry(String value) {
        setValue("country", value);
        return this;
    }

    /**
     * The floor identifier. Discussion [Issue-1132]
     */
    public Address setFloor(String value) {
        setValue("floor", value);
        return this;
    }

    /**
     * The full mailing address, formatted for display or use with a mailing
     * label. This field MAY contain newlines. This is the Primary Sub-Field for
     * this field, for the purposes of sorting and filtering.
     */
    public Address setFormatted(String value) {
        setValue("formatted", value);
        return this;
    }

    /**
     * Expresses the latitude of the location on a map.
     */
    public Address setLatitude(String value) {
        setValue("latitude", value);
        return this;
    }

    /**
     * The city or locality component.
     */
    public Address setLocality(String value) {
        setValue("locality", value);
        return this;
    }

    /**
     * Expresses the longitude of the location on a map.
     */
    public Address setLongitude(String value) {
        setValue("longitude", value);
        return this;
    }

    /**
     * The zipcode or postal code component.
     */
    public Address setPostalCode(String value) {
        setValue("postalCode", value);
        return this;
    }

    /**
     * The state or region component.
     */
    public Address setRegion(String value) {
        setValue("region", value);
        return this;
    }

    /**
     * The full street address component, which may include house number, street
     * name, PO BOX, and multi-line extended street address information. This
     * field MAY contain newlines.
     */
    public Address setStreetAddress(String value) {
        setValue("streetAddress", value);
        return this;
    }

    /**
     * The address type or label. Examples include 'work', 'home'.
     */
    public Address setType(String value) {
        setValue("type", value);
        return this;
    }

}

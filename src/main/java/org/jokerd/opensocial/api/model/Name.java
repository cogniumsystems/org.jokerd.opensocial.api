package org.jokerd.opensocial.api.model;

import org.ubimix.commons.json.IJsonAccessor.JsonType;

/**
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/1.0/Social-Data.xml#Name
public class Name extends DataObject {

    public static IJsonValueFactory<Name> FACTORY = new IJsonValueFactory<Name>() {
        @Override
        public Name newValue(Object object) {
            Name result = null;
            if (fAccessor.getType(object) == JsonType.STRING) {
                result = new Name();
                String str = fAccessor.toString(object);
                result.setGivenName(str);
            } else {
                result = new Name().setJsonObject(object);
            }
            return result;
        }
    };

    /**
     * The family name of this PersonMin, or "Last Name" in most Western
     * languages (e.g. Smarr given the full name Mr. Joseph Robert Smarr, Esq.).
     */
    public String getFamilyName() {
        return getString("familyName ");
    }

    /**
     * The full name, including all middle names, titles, and suffixes as
     * appropriate, formatted for display (e.g. Mr. Joseph Robert Smarr, Esq.).
     * This is the Primary Sub-Field for this field, for the purposes of sorting
     * and filtering.
     * 
     * @param value
     * @return
     */
    public String getFormattedName() {
        String str = getString("formatted");
        if (str != null) {
            return str;
        }

        StringBuilder buf = new StringBuilder();

        str = getGivenName();
        if (str != null) {
            buf.append(str);
        }

        str = getMiddleName();
        if (str != null) {
            if (buf.length() > 0) {
                buf.append(" ");
            }
            buf.append(str);
        }

        str = getFamilyName();
        if (str != null) {
            if (buf.length() > 0) {
                buf.append(" ");
            }
            buf.append(str);
        }

        if (buf.length() > 0) {
            str = getHonorificPrefix();
            if (str != null) {
                buf.insert(0, " ");
                buf.insert(0, str);
            }
            str = getHonorificSuffix();
            if (str != null) {
                buf.append(" ");
                buf.append(str);
            }
        }
        return buf.toString();
    }

    /**
     * The given name of this PersonMin, or "First Name" in most Western
     * languages (e.g. Joseph given the full name Mr. Joseph Robert Smarr,
     * Esq.).
     */
    public String getGivenName() {
        return getString("givenName");
    }

    /**
     * The honorific prefix(es) of this PersonMin, or "Title" in most Western
     * languages (e.g. Mr. given the full name Mr. Joseph Robert Smarr, Esq.).
     */
    public String getHonorificPrefix() {
        return getString("honorificPrefix");
    }

    /**
     * The honorifix suffix(es) of this PersonMin, or "Suffix" in most Western
     * languages (e.g. Esq. given the full name Mr. Joseph Robert Smarr, Esq.).
     */
    public String getHonorificSuffix() {
        return getString("honorificSuffix");
    }

    /**
     * The middle name(s) of this PersonMin (e.g. Robert given the full name Mr.
     * Joseph Robert Smarr, Esq.).
     */
    public String getMiddleName() {
        return getString("middleName");
    }

    /**
     * The family name of this PersonMin, or "Last Name" in most Western
     * languages (e.g. Smarr given the full name Mr. Joseph Robert Smarr, Esq.).
     */
    public Name setFamilyName(String value) {
        setValue("familyName", value);
        return this;
    }

    /**
     * The full name, including all middle names, titles, and suffixes as
     * appropriate, formatted for display (e.g. Mr. Joseph Robert Smarr, Esq.).
     * This is the Primary Sub-Field for this field, for the purposes of sorting
     * and filtering.
     * 
     * @param value
     * @return
     */
    public Name setFormatted(String value) {
        setValue("formatted", value);
        return this;
    }

    /**
     * The given name of this PersonMin, or "First Name" in most Western
     * languages (e.g. Joseph given the full name Mr. Joseph Robert Smarr,
     * Esq.).
     */
    public Name setGivenName(String value) {
        setValue("givenName", value);
        return this;
    }

    /**
     * The honorific prefix(es) of this PersonMin, or "Title" in most Western
     * languages (e.g. Mr. given the full name Mr. Joseph Robert Smarr, Esq.).
     */
    public Name setHonorificPrefix(String value) {
        setValue("honorificPrefix", value);
        return this;
    }

    /**
     * The honorifix suffix(es) of this PersonMin, or "Suffix" in most Western
     * languages (e.g. Esq. given the full name Mr. Joseph Robert Smarr, Esq.).
     */
    public Name setHonorificSuffix(String value) {
        setValue("honorificSuffix", value);
        return this;
    }

    /**
     * The middle name(s) of this PersonMin (e.g. Robert given the full name Mr.
     * Joseph Robert Smarr, Esq.).
     */
    public Name setMiddleName(String value) {
        setValue("middleName", value);
        return this;
    }

}
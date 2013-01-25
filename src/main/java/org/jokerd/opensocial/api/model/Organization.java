package org.jokerd.opensocial.api.model;

import org.ubimix.commons.json.ext.FormattedDate;

/**
 * Describes a current or past organizational affiliation of this contact.
 * Service Providers that support only a single Company Name and Job Title field
 * should represent them with a single organization element with name and title
 * properties, respectively.
 * 
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/2.0.1/Social-Data.xml#Organization
public class Organization extends DataObject {

    public static IJsonValueFactory<Organization> FACTORY = new IJsonValueFactory<Organization>() {
        @Override
        public Organization newValue(Object object) {
            return new Organization().setJsonObject(object);
        }
    };

    /**
     * Address The physical address of this organization.
     */
    public Address getAddress() {
        return getValue("address", Address.FACTORY);
    }

    /**
     * The department within this organization.
     */
    public String getDepartment() {
        return getString("department");
    }

    /**
     * A textual description of the role this PersonMin played in this
     * organization. This field MAY contain newlines.
     */
    public String getDescription() {
        return getString("description");
    }

    /**
     * Date or string The date this PersonMin left this organization or the role
     * specified by title within this organization. This value SHOULD be a valid
     * Date if possible, but MAY be an unformatted string, since it is
     * recognized that this field is often presented as free-text.
     */
    public FormattedDate getEndDate() {
        return getValue("endDate", FormattedDate.FACTORY);
    }

    /**
     * The field the Organization is in.
     */
    public String getField() {
        return getString("field");
    }

    /**
     * The physical location of this organization. This is an abbreviated
     * location like "San Francisco". The container could choose to implement
     * either "address" or "location" field, or both.
     */
    public String getLocation() {
        return getString("location");
    }

    /**
     * The name of the organization (e.g. company, school, or other
     * organization). This field MUST have a non-empty value for each
     * organization returned. This is the Primary Sub-Field for this field, for
     * the purposes of sorting and filtering.
     */
    public String getName() {
        return getString("name");
    }

    /**
     * The salary the person receieves from the organization
     */
    public String getSalary() {
        return getString("salary");
    }

    /**
     * Date or string The date this PersonMin joined this organization. This
     * value SHOULD be a valid Date if possible, but MAY be an unformatted
     * string, since it is recognized that this field is often presented as
     * free-text.
     */
    public FormattedDate getStartDate() {
        return getValue("startDate", FormattedDate.FACTORY);
    }

    /**
     * The subfield the Organization is in.
     */
    public String getSubfield() {
        return getString("subfield");
    }

    /**
     * The job title or organizational role within this organization.
     */
    public String getTitle() {
        return getString("title");
    }

    /**
     * The type of organization, with Canonical Values job and school.
     */
    public String getType() {
        return getString("type");
    }

    /**
     * A webpage related to the organization.
     */
    public String getWebpage() {
        return getString("webpage");
    }

    /**
     * Address The physical address of this organization.
     */
    public Organization setAddress(Address value) {
        setValue("address", value);
        return this;
    }

    /**
     * The department within this organization.
     */
    public Organization setDepartment(String value) {
        setValue("department", value);
        return this;
    }

    /**
     * Date or string The date this PersonMin left this organization or the role
     * specified by title within this organization. This value SHOULD be a valid
     * Date if possible, but MAY be an unformatted string, since it is
     * recognized that this field is often presented as free-text.
     */
    public Organization setDescription(FormattedDate value) {
        setValue("endDate", value);
        return this;
    }

    /**
     * A textual description of the role this PersonMin played in this
     * organization. This field MAY contain newlines.
     */
    public Organization setDescription(String value) {
        setValue("description", value);
        return this;
    }

    /**
     * The field the Organization is in.
     */
    public Organization setField(String value) {
        setValue("field", value);
        return this;
    }

    /**
     * The physical location of this organization. This is an abbreviated
     * location like "San Francisco". The container could choose to implement
     * either "address" or "location" field, or both.
     */
    public Organization setLocation(String value) {
        setValue("location", value);
        return this;
    }

    /**
     * The name of the organization (e.g. company, school, or other
     * organization). This field MUST have a non-empty value for each
     * organization returned. This is the Primary Sub-Field for this field, for
     * the purposes of sorting and filtering.
     */
    public Organization setName(String value) {
        setValue("name", value);
        return this;
    }

    /**
     * The salary the person receieves from the organization
     */
    public Organization setSalary(String value) {
        setValue("salary", value);
        return this;
    }

    /**
     * Date or string The date this PersonMin joined this organization. This
     * value SHOULD be a valid Date if possible, but MAY be an unformatted
     * string, since it is recognized that this field is often presented as
     * free-text.
     */
    public Organization setStartDate(FormattedDate value) {
        setValue("startDate", value);
        return this;
    }

    /**
     * The subfield the Organization is in.
     */
    public Organization setSubfield(String value) {
        setValue("subfield", value);
        return this;
    }

    /**
     * The job title or organizational role within this organization.
     */
    public Organization setTitle(String value) {
        setValue("title", value);
        return this;
    }

    /**
     * The type of organization, with Canonical Values job and school.
     */
    public Organization setType(String value) {
        setValue("type", value);
        return this;
    }

    /**
     * A webpage related to the organization.
     */
    public Organization setWebpage(String value) {
        setValue("webpage", value);
        return this;
    }

}

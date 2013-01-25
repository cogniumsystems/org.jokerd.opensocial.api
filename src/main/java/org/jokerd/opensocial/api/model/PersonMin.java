package org.jokerd.opensocial.api.model;

import org.ubimix.commons.json.ext.FormattedDate;

/**
 * Each person returned MUST include the "id", "name", and "thumbnailUrl" fields
 * with non-empty values, but all other fields are optional, and it is
 * recognized that not all Service Providers are able to provide data for all
 * the supported fields. The field list below is broad so that there is a
 * standard field name available among Service Providers that do support any of
 * these fields. There are two special PersonMin objects that can be requested
 * directly: the VIEWER and the OWNER. To understand the distinction, imagine
 * you're checking out a coworker's profile on Orkut. In this case, you are the
 * VIEWER and your coworker is the OWNER. It's also common to view your own
 * profile, in which case you are both the VIEWER and the OWNER, and some
 * applications may choose to handle this case differently. OpenSocial also
 * provides for the case of anonymous viewing, where the gadget will not be able
 * to access the VIEWER's information.
 * 
 * <pre>
 *  PersonMin   = "{"
 *                    "id :" User-ID ","
 *                    "displayName :" string ","
 *                    [ #PersonMin-Field ]
 *                "}"
 * </pre>
 * 
 * <pre>
 *  {
 *      "id" : "example.org:34KJDCSKJN2HHF0DW20394",
 *      "displayName" : "Janey",
 *      "name" : {"formatted" : "Jane Doe"},
 *      "gender" : "female"
 *  }
 * </pre>
 * 
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/2.0.1/Social-Data.xml#Person
@RequiredField(name = { "id", "displayName" })
public class PersonMin extends ActivityObject {
    public static IJsonValueFactory<PersonMin> FACTORY = new IJsonValueFactory<PersonMin>() {
        public PersonMin newValue(Object object) {
            return new PersonMin().setJsonObject(object);
        }
    };

    public static PersonMin newValue(Object o) {
        return FACTORY.newValue(o);
    }

    /**
     * The name of this PersonMin, suitable for display to end-users. Required.
     * Each PersonMin returned MUST include a non-empty displayName value. The
     * name SHOULD be the full name of the PersonMin being described if known
     * (e.g. Cassandra Doll or Mrs. Cassandra Lynn Doll, Esq.), but MAY be a
     * username or handle, if that is all that is available (e.g. doll). The
     * value provided SHOULD be the primary textual label by which this
     * PersonMin is normally displayed by the Service Provider when presenting
     * it to end-users.
     * 
     * @return The name of this PersonMin
     */
    @Override
    public String getDisplayName() {
        String str = super.getDisplayName();
        if (str == null) {
            str = getString("nickname");
            if (str == null) {
                Name n = getName();
                if (n != null) {
                    str = n.getFormattedName();
                }
            }
        }
        if (str == null) {
            str = "unknown";
        }
        return str;
    }

    /**
     * Unique identifier for the PersonMin. Required.
     * 
     * @return
     */
    @Override
    public UserId getId() {
        String str = getIdAsString();
        return UserId.FACTORY.newValue(str);
    }

    /**
     * The broken-out components and fully formatted version of the person's
     * real name.
     * 
     * @return the name of this person
     */
    public Name getName() {
        return getObject("name", Name.FACTORY);
    }

    /**
     * PersonMin's photo thumbnail URL, specified as a string. This URL must be
     * fully qualified. Relative URLs will not work in gadgets.
     */
    public String getThumbnailUrl() {
        return getString("thumbnailUrl");
    }

    /**
     * The name of this PersonMin, suitable for display to end-users. Required.
     * Each PersonMin returned MUST include a non-empty displayName value. The
     * name SHOULD be the full name of the PersonMin being described if known
     * (e.g. Cassandra Doll or Mrs. Cassandra Lynn Doll, Esq.), but MAY be a
     * username or handle, if that is all that is available (e.g. doll). The
     * value provided SHOULD be the primary textual label by which this
     * PersonMin is normally displayed by the Service Provider when presenting
     * it to end-users.
     */
    @Override
    public PersonMin setDisplayName(String name) {
        return (PersonMin) super.setDisplayName(name);
    }

    /**
     * Unique identifier for the PersonMin. Required.
     */
    public PersonMin setId(UserId id) {
        return (PersonMin) super.setId(id);
    }

    /**
     * The broken-out components and fully formatted version of the person's
     * real name.
     */
    public PersonMin setName(Name name) {
        setValue("name", name);
        return this;
    }

    /**
     * PersonMin's photo thumbnail URL, specified as a string. This URL must be
     * fully qualified. Relative URLs will not work in gadgets.
     */
    public PersonMin setThumbnailUrl(String url) {
        setValue("thumbnailUrl", url);
        return this;
    }

    /**
     * The most recent date the details of this PersonMin were updated (i.e. the
     * modified date of this entry). The value MUST be a valid Date. If this
     * PersonMin has never been modified since its initial creation, the value
     * MUST be the same as the value of published. Note the updatedSince Query
     * Parameter can be used to select only people whose updated value is equal
     * to or more recent than a given Date. This enables Consumers to repeatedly
     * access a user's data and only request newly added or updated contacts
     * since the last access time.
     */
    @Override
    public PersonMin setUpdated(FormattedDate date) {
        return (PersonMin) super.setUpdated(date);
    }

}
package org.jokerd.opensocial.api.model;

import java.util.Arrays;
import java.util.List;

import org.ubimix.commons.json.JsonValue;
import org.ubimix.commons.json.ext.FormattedDate;

/**
 * Each person returned MUST include the "id" and "name" fields with non-empty
 * values, but all other fields are optional, and it is recognized that not all
 * Service Providers are able to provide data for all the supported fields. The
 * field list below is broad so that there is a standard field name available
 * among Service Providers that do support any of these fields. Discussion
 * [Issue-1218]
 * <p>
 * There are two special Person objects that can be requested directly: the
 * VIEWER and the OWNER. To understand the distinction, imagine you're checking
 * out a coworker's profile on Orkut. In this case, you are the VIEWER and your
 * coworker is the OWNER. It's also common to view your own profile, in which
 * case you are both the VIEWER and the OWNER, and some applications may choose
 * to handle this case differently. OpenSocial also provides for the case of
 * anonymous viewing, where the gadget will not be able to access the VIEWER's
 * information.
 * </p>
 * 
 * <pre>
 *        Person   = "{"
 *                       "id :" User-ID ","
 *                       "displayName :" string ","
 *                       [ #Person-Field ]
 *                   "}"
 * </pre>
 * <p>
 * OpenSocial defines many common attributes associated with a person and is
 * aligned with the Portable Contacts specification. However, only display name
 * and id are required and all others are optional. In practice, support for
 * these fields varies greatly among containers. As OpenSocial continues to be
 * adopted as an enterprise programming model, many of these fields are not
 * appropriate based on the considerations of Human Resource guidelines.
 * Discussion [Issue-1132]
 * </p>
 * <p>
 * In an attempt to balance the needs of consumer vs corporate focused
 * OpenSocial applications, and increase interoperability, the specification is
 * refining attempting to provide clarity around attributes that are broadly
 * applicable across both the consumer and enterprise domain, and those that are
 * more appropriate for consumer oriented systems.
 * </p>
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
public class Person extends PersonMin {

    public static IJsonValueFactory<Person> FACTORY = new IJsonValueFactory<Person>() {
        @Override
        public Person newValue(Object object) {
            return new Person().setJsonObject(object);
        }
    };

    /**
     * List of alternative names. These may include known aliases, maiden-names,
     * nicknames, acceptable alternative forms of the same name (e.g. "James",
     * "Jim", "Jimmy"), etc.
     */
    public Person addAlternateNames(List<Name> values) {
        setValue("alternateNames", values);
        return this;
    }

    /** A general statement about the person. */
    public String getAboutMe() {
        return getString("aboutMe)");
    }

    /** An online account held by this PersonMin. */
    public PluralFields<Account> getAccounts() {
        return getPluralFields("accounts", Account.FACTORY);
    }

    /** PersonMin's favorite activities. */
    public PluralFields<String> getActivities() {
        return getPluralFields("activities", JsonValue.STRING_FACTORY);
    }

    /** A physical mailing address for this PersonMin. */
    public PluralFields<Address> getAddresses() {
        return getPluralFields("addresses", Address.FACTORY);
    }

    /**
     * The age of this person. Sometimes sites might want to show age without
     * revealing the specific birthday.
     */
    public int getAge() {
        return getInteger("age", -1);
    }

    /**
     * List of alternative names. These may include known aliases, maiden-names,
     * nicknames, acceptable alternative forms of the same name (e.g. "James",
     * "Jim", "Jimmy"), etc.
     */
    public PluralFields<Name> getAlternateNames() {
        return getPluralFields("alternateNames", Name.FACTORY);
    }

    /**
     * The wedding anniversary of this person. The value MUST be a valid Date.
     * The year value MAY be set to 0000 when the year is not available.
     */
    public FormattedDate getAnniversary() {
        return getValue("anniversary", FormattedDate.FACTORY);
    }

    /** A collection of AppData keys and values. */
    public PluralFields<AppData> getAppData() {
        return getPluralFields("appData", AppData.FACTORY);
    }

    /**
     * The birthday of this person. The value MUST be a valid Date. The year
     * value MAY be set to 0000 when the age of the PersonMin is private or the
     * year is not available.
     */
    public FormattedDate getBirthday() {
        return getValue("birthday", FormattedDate.FACTORY);
    }

    /** PersonMin's body characteristics. */
    public String getBodyType() {
        return getString("bodyType)");
    }

    /** PersonMin's favorite books. */
    public PluralFields<String> getBooks() {
        return getPluralFields("books", JsonValue.STRING_FACTORY);
    }

    /** PersonMin's favorite cars. */
    public PluralFields<String> getCars() {
        return getPluralFields("cars", JsonValue.STRING_FACTORY);
    }

    /** Description of the person's children. */
    public PluralFields<String> getChildren() {
        return getPluralFields("children   ", JsonValue.STRING_FACTORY);
    }

    /**
     * Boolean value indicating whether the user and this PersonMin have
     * established a bi-directionally asserted connection of some kind on the
     * Service Provider's service. The value MUST be either true or false. The
     * value MUST be true if and only if there is at least one value for the
     * relationship field, described below, and is thus intended as a summary
     * value indicating that some type of bi-directional relationship exists,
     * for Consumers that aren't interested in the specific nature of that
     * relationship. For traditional address books, in which a user stores
     * information about other contacts without their explicit acknowledgment,
     * or for services in which users choose to "follow" other users without
     * requiring mutual consent, this value will always be false.
     */
    public boolean getConnected() {
        return getBoolean("connected", false);
    }

    /**
     * Human-readable summarization of the Person's contact preferences. For
     * instance, a person may choose to specify something along the lines of,
     * "Please use instant messaging to contact me prior to calling."
     */
    public String getContactPreference() {
        return getString("contactPreference");
    }

    /**
     * This Person's X.500 'Distinguished Name'
     */
    public String getDn() {
        return getString("dn");
    }

    /** PersonMin's drinking status. */
    public String getDrinker() {
        return getString("drinker)");
    }

    /**
     * E-mail address for this PersonMin. The value SHOULD be canonicalized by
     * the Service Provider, e.g.joseph@plaxo.com instead of joseph@PLAXO.COM.
     */
    public PluralFields<String> getEmails() {
        return getPluralFields("emails", JsonValue.STRING_FACTORY);
    }

    /** PersonMin's ethnicity. */
    public String getEthnicity() {
        return getString("ethnicity");
    }

    /** PersonMin's thoughts on fashion. */
    public String getFashion() {
        return getString("fashion");
    }

    /** PersonMin's favorite food. */
    public PluralFields<String> getFood() {
        return getPluralFields("food", JsonValue.STRING_FACTORY);
    }

    /**
     * The gender of this person. Service Providers SHOULD return one of the
     * following Canonical Values, if appropriate:male, female, or undisclosed,
     * and MAY return a different value if it is not covered by one of these
     * Canonical Values.
     */
    public String getGender() {
        return getString("gender");
    }

    /** Describes when the person is happiest. */
    public String getHappiestWhen() {
        return getString("happiestWhen");
    }

    /** Indicating whether the user has application installed. */
    public Boolean getHasApp() {
        return getBoolean("hasApp", false);
    }

    /** PersonMin's favorite heroes. */
    public PluralFields<String> getHeroes() {
        return getPluralFields("heroes", JsonValue.STRING_FACTORY);
    }

    /** PersonMin's thoughts on humor. */
    public String getHumor() {
        return getString("humor");
    }

    /**
     * Instant messaging address for this PersonMin. No official
     * canonicalization rules exist for all instant messaging addresses, but
     * Service Providers SHOULD remove all whitespace and convert the address to
     * lowercase, if this is appropriate for the service this IM address is used
     * for. Instead of the standard Canonical Values for type, this field
     * defines the following Canonical Values to represent currently popular IM
     * services: aim, gtalk, icq, xmpp,msn, skype, qq, and yahoo.
     */
    public PluralFields<String> getIms() {
        return getPluralFields("ims", JsonValue.STRING_FACTORY);
    }

    /** PersonMin's interests, hobbies or passions. */
    public PluralFields<String> getInterests() {
        return getPluralFields("interests", JsonValue.STRING_FACTORY);
    }

    /** PersonMin's favorite jobs, or job interests and skills. */
    public PluralFields<String> getJobInterests() {
        return getPluralFields("jobInterests", JsonValue.STRING_FACTORY);
    }

    /** List of the languages that the person speaks as ISO 639-1 codes. */
    public PluralFields<String> getLanguagesSpoken() {
        return getPluralFields("languagesSpoken", JsonValue.STRING_FACTORY);
    }

    /** Description of the person's living arrangemen. */
    public String getLivingArrangement() {
        return getString("livingArrangement");
    }

    /**
     * 
     */
    public String getLocation() {
        return getString("location");
    }

    /**
     * Person's statement about who or what they are looking for, or what they
     * are interested in meeting people for.
     */
    public String getLookingFor() {
        return getString("lookingFor");
    }

    /** PersonMin's favorite movies. */
    public PluralFields<String> getMovies() {
        return getPluralFields("movies", JsonValue.STRING_FACTORY);
    }

    /** PersonMin's favorite music. */
    public PluralFields<String> getMusic() {
        return getPluralFields("music", JsonValue.STRING_FACTORY);
    }

    /**
     * The broken-out components and fully formatted, native-language version of
     * the person's real name.
     */
    public Name getNativeName() {
        return getValue("nativeName", Name.FACTORY);
    }

    /**
     * PersonMin's current network status. Specified as one of: AWAY, CHAT, DND,
     * OFFLINE, ONLINE OR XA.
     */
    public PluralFields<String> getNetworkPresence() {
        return getPluralFields("networkPresence", JsonValue.STRING_FACTORY);
    }

    /**
     * The casual way to address this PersonMin in real life, e.g. "Bob" or
     * "Bobby" instead of "Robert". This field SHOULD NOT be used to represent a
     * user's username (e.g. jsmarr or daveman692); the latter should be
     * represented by the preferredUsername field.
     */
    public String getNickname() {
        return getString("nickname");
    }

    /**
     * Notes about this person, with an unspecified meaning or usage (normally
     * notes by the user about this person). This field MAY contain newlines.
     */
    public String getNote() {
        return getString("note");
    }

    /** A current or past organizational affiliation of this PersonMin. */
    public PluralFields<Organization> getOrganizations() {
        return getPluralFields("organizations  ", Organization.FACTORY);
    }

    /**
     * Listing of this person's organizational identifiers (e.g. employee serial
     * number, student number, etc)
     */
    public PluralFields<String> getOrgIdentifier() {
        return getPluralFields("orgIdentifier", STRING_FACTORY);
    }

    /** Description of the person's pets */
    public PluralFields<String> getPets() {
        return getPluralFields("pets", JsonValue.STRING_FACTORY);
    }

    /**
     * Phone number for this PersonMin. No canonical value is assumed here. In
     * addition to the standard Canonical Values for type, this field also
     * defines the additional Canonical Values mobile, fax, and pager.
     */
    public PluralFields<String> getPhoneNumbers() {
        return getPluralFields("phoneNumbers", JsonValue.STRING_FACTORY);
    }

    /**
     * URL of a photo of this person. The value SHOULD be a canonicalized URL,
     * and MUST point to an actual image file (e.g. a GIF, JPEG, or PNG image
     * file) rather than to a web page containing an image. Service Providers
     * MAY return the same image at different sizes, though it is recognized
     * that no standard for describing images of various sizes currently exists.
     * Note that this field SHOULD NOT be used to send down arbitrary photos
     * taken by this user, but specifically profile photos of the contact
     * suitable for display when describing the contact.
     */
    public PluralFields<String> getPhotos() {
        return getPluralFields("photos", JsonValue.STRING_FACTORY);
    }

    /** PersonMin's political views. */
    public PluralFields<String> getPoliticalViews() {
        return getPluralFields("politicalViews", JsonValue.STRING_FACTORY);
    }

    /**
     * The broken-out components and fully formatted version of the person's
     * preferred name.
     */
    public Name getPreferredName() {
        return getValue("preferredName", Name.FACTORY);
    }

    /**
     * The preferred username of this person on sites that ask for a username
     * (e.g. jsmarr or daveman692). This field may be more useful for describing
     * the owner (i.e. the value when /@me/@self is requested) than the user's
     * person, e.g. Consumers MAY wish to use this value to pre-populate a
     * username for this user when signing up for a new service.
     */
    public String getPreferredUsername() {
        return getString("preferredUsername");
    }

    /** URL of a person's profile song. */
    public String getProfileSong() {
        return getString("profileSong");
    }

    /**
     * PersonMin's profile URL, specified as a string. This URL must be fully
     * qualified. Relative URLs will not work in gadgets.
     */
    public String getProfileUrl() {
        return getString("profileUrl");
    }

    /** URL of a person's profile video. */
    public String getProfileVideo() {
        return getString("profileVideo");
    }

    /** PersonMin's favorite quotes */
    public PluralFields<String> getQuotes() {
        return getPluralFields("quotes", JsonValue.STRING_FACTORY);
    }

    /**
     * A bi-directionally asserted relationship type that was established
     * between the user and this person by the Service Provider. The value
     * SHOULD conform to one of the XFN relationship values (e.g. kin, friend,
     * contact, etc.) if appropriate, but MAY be an alternative value if needed.
     * Note this field is a parallel set of category labels to the tags field,
     * but relationships MUST have been bi-directionally confirmed, whereas tags
     * are asserted by the user without acknowledgment by this PersonMin. Note
     * that this field consists only of a string value.
     */
    public PluralFields<String> getRelationships() {
        return getPluralFields("relationships", JsonValue.STRING_FACTORY);
    }

    /** PersonMin's relationship status. */
    public String getRelationshipStatus() {
        return getString("relationshipStatus");
    }

    /** PersonMin's relgion or religious views. */
    public String getReligion() {
        return getString("religion");
    }

    /** PersonMin's comments about romance. */
    public String getRomance() {
        return getString("romance");
    }

    /** What the person is scared of. */
    public String getScaredOf() {
        return getString("scaredOf");
    }

    /** PersonMin's sexual orientation. */
    public String getSexualOrientation() {
        return getString("sexualOrientation");
    }

    /** PersonMin's smoking status. */
    public String getSmoker() {
        return getString("smoker");
    }

    /** PersonMin's favorite sports */
    public PluralFields<String> getSports() {
        return getPluralFields("sports", JsonValue.STRING_FACTORY);
    }

    /** PersonMin's status, headline or shoutout. */
    public String getStatus() {
        return getString("status");
    }

    /**
     * A user-defined category label for this person, e.g. "favorite" or
     * "web20". These values SHOULD be case-insensitive, and there SHOULD NOT be
     * multiple tags provided for a given person that differ only in case. Note
     * that this field consists only of a string value.
     */
    //
    public PluralFields<String> getTags() {
        return getPluralFields("tags", JsonValue.STRING_FACTORY);
    }

    /** PersonMin's turn offs. */
    public PluralFields<String> getTurnOffs() {
        return getPluralFields("turnOffs", JsonValue.STRING_FACTORY);
    }

    /** PersonMin's turn ons. */
    public PluralFields<String> getTurnOns() {
        return getPluralFields("turnOns", JsonValue.STRING_FACTORY);
    }

    /** PersonMin's favorite TV shows. */
    public PluralFields<String> getTvShows() {
        return getPluralFields("tvShows", JsonValue.STRING_FACTORY);
    }

    /**
     * URL of a web page relating to this PersonMin. The value SHOULD be
     * canonicalized by the Service Provider, e.g.http://josephsmarr.com/about/
     * instead of JOSEPHSMARR.COM/about/. In addition to the standard Canonical
     * Values for type, this field also defines the additional Canonical Values
     * blog and profile.
     */
    public PluralFields<String> getUrls() {
        return getPluralFields("urls", JsonValue.STRING_FACTORY);
    }

    /**
     * The offset from UTC of this PersonMin's current // time zone, as of the
     * time this response was returned. The value MUST // conform to the
     * Date-UTC-Offset. Note that this value MAY change over time // due to
     * daylight saving time, and is thus meant to signify only the // current
     * value of the user's timezone offset.
     */
    public DateUTCOffset getUtcOffset() {
        return getValue("utcOffset", DateUTCOffset.FACTORY);
    }

    /** A general statement about the person. */
    public Person setAboutMe(String value) {
        setValue("aboutMe", value);
        return this;
    }

    /** An online account held by this PersonMin. */
    public Person setAccounts(Account... values) {
        setValue("accounts", values);
        return this;
    }

    /** An online account held by this PersonMin. */
    public Person setAccounts(List<Account> values) {
        setValue("accounts", values);
        return this;
    }

    /** PersonMin's favorite activities. */
    public Person setActivities(List<String> values) {
        setValue("activities", values);
        return this;
    }

    /** PersonMin's favorite activities. */
    public Person setActivities(String... values) {
        setValue("activities", values);
        return this;
    }

    /** A physical mailing address for this PersonMin. */
    public Person setAddresses(Address... values) {
        setValue("addresses", values);
        return this;
    }

    /** A physical mailing address for this PersonMin. */
    public Person setAddresses(List<Address> values) {
        setValue("addresses", values);
        return this;
    }

    /**
     * The age of this person. Sometimes sites might want to show age without
     * revealing the specific birthday.
     */
    public Person setAge(int value) {
        setValue("age", value);
        return this;
    }

    /**
     * The wedding anniversary of this person. The value MUST be a valid Date.
     * The year value MAY be set to 0000 when the year is not available.
     */
    public Person setAnniversary(FormattedDate value) {
        setValue("anniversary", value);
        return this;
    }

    /** A collection of AppData keys and values. */
    public Person setAppData(AppData... values) {
        setValue("appData", values);
        return this;
    }

    /** A collection of AppData keys and values. */
    public Person setAppData(List<AppData> values) {
        setValue("appData", values);
        return this;
    }

    /**
     * The birthday of this person. The value MUST be a valid Date. The year
     * value MAY be set to 0000 when the age of the PersonMin is private or the
     * year is not available.
     */
    public Person setBirthday(FormattedDate value) {
        setValue("birthday", value);
        return this;
    }

    /** PersonMin's body characteristics. */
    public Person setBodyType(String value) {
        setValue("bodyType", value);
        return this;
    }

    /** PersonMin's favorite books. */
    public Person setBooks(List<String> values) {
        setValue("books", values);
        return this;
    }

    /** PersonMin's favorite books. */
    public Person setBooks(String... values) {
        setValue("books", values);
        return this;
    }

    /** PersonMin's favorite cars. */
    public Person setCars(List<String> values) {
        setValue("cars", values);
        return this;
    }

    /** PersonMin's favorite cars. */
    public Person setCars(String... values) {
        setValue("cars", values);
        return this;
    }

    /** Description of the person's children. */
    public Person setChildren(List<String> values) {
        setValue("children", values);
        return this;
    }

    /** Description of the person's children. */
    public Person setChildren(String... values) {
        setValue("children", values);
        return this;
    }

    /**
     * Boolean value indicating whether the user and this PersonMin have
     * established a bi-directionally asserted connection of some kind on the
     * Service Provider's service. The value MUST be either true or false. The
     * value MUST be true if and only if there is at least one value for the
     * relationship field, described below, and is thus intended as a summary
     * value indicating that some type of bi-directional relationship exists,
     * for Consumers that aren't interested in the specific nature of that
     * relationship. For traditional address books, in which a user stores
     * information about other contacts without their explicit acknowledgment,
     * or for services in which users choose to "follow" other users without
     * requiring mutual consent, this value will always be false.
     */
    public Person setConnected(Boolean value) {
        setValue("connected", value);
        return this;
    }

    /**
     * Human-readable summarization of the Person's contact preferences. For
     * instance, a person may choose to specify something along the lines of,
     * "Please use instant messaging to contact me prior to calling."
     */
    public Person setContactPreference(String value) {
        setValue("contactPreference", value);
        return this;
    }

    @Override
    public Person setDisplayName(String name) {
        return (Person) super.setDisplayName(name);
    }

    /**
     * This Person's X.500 'Distinguished Name'
     */
    public Person setDn(String value) {
        setValue("dn", value);
        return this;
    }

    /** PersonMin's drinking status. */
    public Person setDrinker(String value) {
        setValue("drinker", value);
        return this;
    }

    /**
     * E-mail address for this PersonMin. The value SHOULD be canonicalized by
     * the Service Provider, e.g.joseph@plaxo.com instead of joseph@PLAXO.COM.
     */
    public Person setEmails(List<String> values) {
        setValue("emails", values);
        return this;
    }

    /**
     * E-mail address for this PersonMin. The value SHOULD be canonicalized by
     * the Service Provider, e.g.joseph@plaxo.com instead of joseph@PLAXO.COM.
     */
    public Person setEmails(String... values) {
        setValue("emails", values);
        return this;
    }

    /** PersonMin's ethnicity. */
    public Person setEthnicity(String value) {
        setValue("ethnicity", value);
        return this;
    }

    /** PersonMin's thoughts on fashion. */
    public Person setFashion(String value) {
        setValue("fashion", value);
        return this;
    }

    /** PersonMin's favorite food. */
    public Person setFood(List<String> values) {
        setValue("food", values);
        return this;
    }

    /** PersonMin's favorite food. */
    public Person setFood(String... values) {
        setValue("food", values);
        return this;
    }

    /**
     * The gender of this person. Service Providers SHOULD return one of the
     * following Canonical Values, if appropriate:male, female, or undisclosed,
     * and MAY return a different value if it is not covered by one of these
     * Canonical Values.
     */
    public Person setGender(String value) {
        setValue("gender", value);
        return this;
    }

    /** Describes when the person is happiest. */
    public Person setHappiestWhen(String value) {
        setValue("happiestWhen", value);
        return this;
    }

    /** Indicating whether the user has application installed. */
    public Person setHasApp(Boolean value) {
        setValue("hasApp", value);
        return this;
    }

    /** PersonMin's favorite heroes. */
    public Person setHeroes(List<String> values) {
        setValue("heroes", values);
        return this;
    }

    /** PersonMin's favorite heroes. */
    public Person setHeroes(String... values) {
        setValue("heroes", values);
        return this;
    }

    /** PersonMin's thoughts on humor. */
    public Person setHumor(String value) {
        setValue("humor", value);
        return this;
    }

    public final void setId(Account account) {
        UserId userId = account.getUserId();
        setId(userId);
        String name = getDisplayName();
        if (name == null) {
            String username = account.getUsername();
            setDisplayName(username);
        }
        setAccounts(Arrays.asList(account));
    }

    @Override
    public Person setId(UserId id) {
        return (Person) super.setId(id);
    }

    /**
     * Instant messaging address for this PersonMin. No official
     * canonicalization rules exist for all instant messaging addresses, but
     * Service Providers SHOULD remove all whitespace and convert the address to
     * lowercase, if this is appropriate for the service this IM address is used
     * for. Instead of the standard Canonical Values for type, this field
     * defines the following Canonical Values to represent currently popular IM
     * services: aim, gtalk, icq, xmpp,msn, skype, qq, and yahoo.
     */
    public Person setIms(List<String> values) {
        setValue("ims", values);
        return this;
    }

    /**
     * Instant messaging address for this PersonMin. No official
     * canonicalization rules exist for all instant messaging addresses, but
     * Service Providers SHOULD remove all whitespace and convert the address to
     * lowercase, if this is appropriate for the service this IM address is used
     * for. Instead of the standard Canonical Values for type, this field
     * defines the following Canonical Values to represent currently popular IM
     * services: aim, gtalk, icq, xmpp,msn, skype, qq, and yahoo.
     */
    public Person setIms(String... values) {
        setValue("ims", values);
        return this;
    }

    /** PersonMin's interests, hobbies or passions. */
    public Person setInterests(List<String> values) {
        setValue("interests", values);
        return this;
    }

    /** PersonMin's interests, hobbies or passions. */
    public Person setInterests(String... values) {
        setValue("interests", values);
        return this;
    }

    /** PersonMin's favorite jobs, or job interests and skills. */
    public Person setJobInterests(List<String> values) {
        setValue("jobInterests", values);
        return this;
    }

    /** PersonMin's favorite jobs, or job interests and skills. */
    public Person setJobInterests(String... values) {
        setValue("jobInterests", values);
        return this;
    }

    /** List of the languages that the person speaks as ISO 639-1 codes. */
    public Person setLanguagesSpoken(List<String> values) {
        setValue("languagesSpoken", values);
        return this;
    }

    /** List of the languages that the person speaks as ISO 639-1 codes. */
    public Person setLanguagesSpoken(String... values) {
        setValue("languagesSpoken", values);
        return this;
    }

    /** Description of the person's living arrangemen. */
    public Person setLivingArrangement(String value) {
        setValue("livingArrangement", value);
        return this;
    }

    /**
     * 
     */
    public Person setLocation(String value) {
        setValue("location", value);
        return this;
    }

    /**
     * Person's statement about who or what they are looking for, or what they
     * are interested in meeting people for.
     */
    public Person setLookingFor(String value) {
        setValue("lookingFor", value);
        return this;
    }

    /** PersonMin's favorite movies. */
    public Person setMovies(List<String> values) {
        setValue("movies", values);
        return this;
    }

    /** PersonMin's favorite movies. */
    public Person setMovies(String... values) {
        setValue("movies", values);
        return this;
    }

    /** PersonMin's favorite music. */
    public Person setMusic(List<String> values) {
        setValue("music", values);
        return this;
    }

    /** PersonMin's favorite music. */
    public Person setMusic(String... values) {
        setValue("music", values);
        return this;
    }

    @Override
    public Person setName(Name name) {
        return (Person) super.setName(name);
    }

    /**
     * The broken-out components and fully formatted, native-language version of
     * the person's real name.
     */
    public Person setNativeName(Name value) {
        setValue("nativeName", value);
        return this;
    }

    /**
     * PersonMin's current network status. Specified as one of: AWAY, CHAT, DND,
     * OFFLINE, ONLINE OR XA.
     */
    public Person setNetworkPresence(List<String> values) {
        setValue("networkPresence", values);
        return this;
    }

    /**
     * PersonMin's current network status. Specified as one of: AWAY, CHAT, DND,
     * OFFLINE, ONLINE OR XA.
     */
    public Person setNetworkPresence(String... values) {
        setValue("networkPresence", values);
        return this;
    }

    /**
     * The casual way to address this PersonMin in real life, e.g. "Bob" or
     * "Bobby" instead of "Robert". This field SHOULD NOT be used to represent a
     * user's username (e.g. jsmarr or daveman692); the latter should be
     * represented by the preferredUsername field.
     */
    public Person setNickname(String value) {
        setValue("nickname", value);
        return this;
    }

    /**
     * Notes about this person, with an unspecified meaning or usage (normally
     * notes by the user about this person). This field MAY contain newlines.
     */
    public Person setNote(String value) {
        setValue("note", value);
        return this;
    }

    /** A current or past organizational affiliation of this PersonMin. */
    public Person setOrganizations(List<Organization> values) {
        setValue("organizations", values);
        return this;
    }

    /** A current or past organizational affiliation of this PersonMin. */
    public Person setOrganizations(Organization... values) {
        setValue("organizations", values);
        return this;
    }

    /**
     * Listing of this person's organizational identifiers (e.g. employee serial
     * number, student number, etc)
     */
    public Person setOrgIdentifier(List<String> values) {
        setValue("orgIdentifier", values);
        return this;
    }

    /**
     * Listing of this person's organizational identifiers (e.g. employee serial
     * number, student number, etc)
     */
    public Person setOrgIdentifier(String... values) {
        setValue("orgIdentifier", values);
        return this;
    }

    /** Description of the person's pets */
    public Person setPets(List<String> values) {
        setValue("pets", values);
        return this;
    }

    /** Description of the person's pets */
    public Person setPets(String... values) {
        setValue("pets", values);
        return this;
    }

    /**
     * Phone number for this PersonMin. No canonical value is assumed here. In
     * addition to the standard Canonical Values for type, this field also
     * defines the additional Canonical Values mobile, fax, and pager.
     */
    public Person setPhoneNumbers(List<String> values) {
        setValue("phoneNumbers", values);
        return this;
    }

    /**
     * Phone number for this PersonMin. No canonical value is assumed here. In
     * addition to the standard Canonical Values for type, this field also
     * defines the additional Canonical Values mobile, fax, and pager.
     */
    public Person setPhoneNumbers(String... values) {
        setValue("phoneNumbers", values);
        return this;
    }

    /**
     * URL of a photo of this person. The value SHOULD be a canonicalized URL,
     * and MUST point to an actual image file (e.g. a GIF, JPEG, or PNG image
     * file) rather than to a web page containing an image. Service Providers
     * MAY return the same image at different sizes, though it is recognized
     * that no standard for describing images of various sizes currently exists.
     * Note that this field SHOULD NOT be used to send down arbitrary photos
     * taken by this user, but specifically profile photos of the contact
     * suitable for display when describing the contact.
     */
    public Person setPhotos(List<String> values) {
        setValue("photos", values);
        return this;
    }

    /**
     * URL of a photo of this person. The value SHOULD be a canonicalized URL,
     * and MUST point to an actual image file (e.g. a GIF, JPEG, or PNG image
     * file) rather than to a web page containing an image. Service Providers
     * MAY return the same image at different sizes, though it is recognized
     * that no standard for describing images of various sizes currently exists.
     * Note that this field SHOULD NOT be used to send down arbitrary photos
     * taken by this user, but specifically profile photos of the contact
     * suitable for display when describing the contact.
     */
    public Person setPhotos(String... values) {
        setValue("photos", values);
        return this;
    }

    /** PersonMin's political views. */
    public Person setPoliticalViews(List<String> values) {
        setValue("politicalViews", values);
        return this;
    }

    /** PersonMin's political views. */
    public Person setPoliticalViews(String... values) {
        setValue("politicalViews", values);
        return this;
    }

    /**
     * The broken-out components and fully formatted version of the person's
     * preferred name.
     */
    public Person setPreferredName(Name value) {
        setValue("preferredName", value);
        return this;
    }

    /**
     * The preferred username of this person on sites that ask for a username
     * (e.g. jsmarr or daveman692). This field may be more useful for describing
     * the owner (i.e. the value when /@me/@self is requested) than the user's
     * person, e.g. Consumers MAY wish to use this value to pre-populate a
     * username for this user when signing up for a new service.
     */
    public Person setPreferredUsername(String value) {
        setValue("preferredUsername", value);
        return this;
    }

    /** URL of a person's profile song. */
    public Person setProfileSong(String value) {
        setValue("profileSong", value);
        return this;
    }

    /**
     * PersonMin's profile URL, specified as a string. This URL must be fully
     * qualified. Relative URLs will not work in gadgets.
     */
    public Person setProfileUrl(String value) {
        setValue("profileUrl", value);
        return this;
    }

    /** URL of a person's profile video. */
    public Person setProfileVideo(String value) {
        setValue("profileVideo", value);
        return this;
    }

    /**
     * The date this PersonMin was first added to the user's address book or
     * friends list (i.e. the creation date of this entry). The value MUST be a
     * valid Date.
     */
    @Override
    public Person setPublished(FormattedDate value) {
        setValue("published", value);
        return this;
    }

    /** PersonMin's favorite quotes */
    public Person setQuotes(List<String> values) {
        setValue("quotes", values);
        return this;
    }

    /** PersonMin's favorite quotes */
    public Person setQuotes(String... values) {
        setValue("quotes", values);
        return this;
    }

    /**
     * A bi-directionally asserted relationship type that was established
     * between the user and this person by the Service Provider. The value
     * SHOULD conform to one of the XFN relationship values (e.g. kin, friend,
     * contact, etc.) if appropriate, but MAY be an alternative value if needed.
     * Note this field is a parallel set of category labels to the tags field,
     * but relationships MUST have been bi-directionally confirmed, whereas tags
     * are asserted by the user without acknowledgment by this PersonMin. Note
     * that this field consists only of a string value.
     */
    public Person setRelationships(List<String> values) {
        setValue("relationships", values);
        return this;
    }

    /**
     * A bi-directionally asserted relationship type that was established
     * between the user and this person by the Service Provider. The value
     * SHOULD conform to one of the XFN relationship values (e.g. kin, friend,
     * contact, etc.) if appropriate, but MAY be an alternative value if needed.
     * Note this field is a parallel set of category labels to the tags field,
     * but relationships MUST have been bi-directionally confirmed, whereas tags
     * are asserted by the user without acknowledgment by this PersonMin. Note
     * that this field consists only of a string value.
     */
    public Person setRelationships(String... values) {
        setValue("relationships", values);
        return this;
    }

    /** PersonMin's relationship status. */
    public Person setRelationshipStatus(String value) {
        setValue("relationshipStatus", value);
        return this;
    }

    /** PersonMin's relgion or religious views. */
    public Person setReligion(String value) {
        setValue("religion", value);
        return this;
    }

    /** PersonMin's comments about romance. */
    public Person setRomance(String value) {
        setValue("romance", value);
        return this;
    }

    /** What the person is scared of. */
    public Person setScaredOf(String value) {
        setValue("scaredOf", value);
        return this;
    }

    /** PersonMin's sexual orientation. */
    public Person setSexualOrientation(String value) {
        setValue("sexualOrientation", value);
        return this;
    }

    /** PersonMin's smoking status. */
    public Person setSmoker(String value) {
        setValue("smoker", value);
        return this;
    }

    /** PersonMin's favorite sports */
    public Person setSports(List<String> values) {
        setValue("sports", values);
        return this;
    }

    /** PersonMin's favorite sports */
    public Person setSports(String... values) {
        setValue("sports", values);
        return this;
    }

    /** PersonMin's status, headline or shoutout. */
    public Person setStatus(String value) {
        setValue("status", value);
        return this;
    }

    /**
     * A user-defined category label for this person, e.g. "favorite" or
     * "web20". These values SHOULD be case-insensitive, and there SHOULD NOT be
     * multiple tags provided for a given person that differ only in case. Note
     * that this field consists only of a string value.
     */
    public Person setTags(List<String> values) {
        setValue("tags", values);
        return this;
    }

    /**
     * A user-defined category label for this person, e.g. "favorite" or
     * "web20". These values SHOULD be case-insensitive, and there SHOULD NOT be
     * multiple tags provided for a given person that differ only in case. Note
     * that this field consists only of a string value.
     */
    public Person setTags(String... values) {
        setValue("tags", values);
        return this;
    }

    @Override
    public Person setThumbnailUrl(String url) {
        return (Person) super.setThumbnailUrl(url);
    }

    /** PersonMin's turn offs. */
    public Person setTurnOffs(List<String> values) {
        setValue("turnOffs", values);
        return this;
    }

    /** PersonMin's turn offs. */
    public Person setTurnOffs(String... values) {
        setValue("turnOffs", values);
        return this;
    }

    /** PersonMin's turn ons. */
    public Person setTurnOns(List<String> values) {
        setValue("turnOns", values);
        return this;
    }

    /** PersonMin's turn ons. */
    public Person setTurnOns(String... values) {
        setValue("turnOns", values);
        return this;
    }

    /** PersonMin's favorite TV shows. */
    public Person setTvShows(List<String> values) {
        setValue("tvShows", values);
        return this;
    }

    /** PersonMin's favorite TV shows. */
    public Person setTvShows(String... values) {
        setValue("tvShows", values);
        return this;
    }

    @Override
    public Person setUpdated(FormattedDate date) {
        return (Person) super.setUpdated(date);
    }

    /**
     * URL of a web page relating to this PersonMin. The value SHOULD be
     * canonicalized by the Service Provider, e.g.http://josephsmarr.com/about/
     * instead of JOSEPHSMARR.COM/about/. In addition to the standard Canonical
     * Values for type, this field also defines the additional Canonical Values
     * blog and profile.
     */
    public Person setUrls(List<String> values) {
        setValue("urls", values);
        return this;
    }

    /**
     * URL of a web page relating to this PersonMin. The value SHOULD be
     * canonicalized by the Service Provider, e.g.http://josephsmarr.com/about/
     * instead of JOSEPHSMARR.COM/about/. In addition to the standard Canonical
     * Values for type, this field also defines the additional Canonical Values
     * blog and profile.
     */
    public Person setUrls(String... values) {
        setValue("urls", values);
        return this;
    }

    /**
     * The offset from UTC of this PersonMin's current // time zone, as of the
     * time this response was returned. The value MUST // conform to the
     * Date-UTC-Offset. Note that this value MAY change over time // due to
     * daylight saving time, and is thus meant to signify only the // current
     * value of the user's timezone offset.
     */
    public Person setUtcOffset(DateUTCOffset offset) {
        return setUtcOffset(offset.toString());
    }

    /**
     * The offset from UTC of this PersonMin's current // time zone, as of the
     * time this response was returned. The value MUST // conform to the
     * Date-UTC-Offset. Note that this value MAY change over time // due to
     * daylight saving time, and is thus meant to signify only the // current
     * value of the user's timezone offset.
     * <p>
     * TODO: Should be the Date-UTC-Offset datatype
     * </p>
     */
    public Person setUtcOffset(String value) {
        setValue("utcOffset", value);
        return this;
    }

}
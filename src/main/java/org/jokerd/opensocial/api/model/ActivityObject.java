/**
 * 
 */
package org.jokerd.opensocial.api.model;

import java.util.List;

import org.ubimix.commons.json.JsonValue;
import org.ubimix.commons.json.ext.FormattedDate;

/**
 * An object is a thing, real or imaginary, which participates in an activity.
 * It may be the entity performing the activity, or the entity on which the
 * activity was performed. Because Activity Streams are often used in the
 * context of a social platform, OpenSocial adds an additional field to the data
 * model, "deliverTo:". Because these are extensions, they are contained in an
 * eclosing "namespace", org.opensocial.
 * 
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/2.0.1/Social-Data.xml#ActivityObject
public class ActivityObject extends DataObject {

    public static IJsonValueFactory<ActivityObject> FACTORY = new IJsonValueFactory<ActivityObject>() {
        @Override
        public ActivityObject newValue(Object object) {
            return new ActivityObject().setJsonObject(object);
        }
    };

    /**
     * 
     */
    public ActivityObject() {
    }

    /**
     * @param object
     */
    public ActivityObject(Object object) {
        super(object);
    }

    /**
     * A collection of one or more additional, associated objects, similar to
     * the concept of attached files in an email message. An object MAY have an
     * attachments property whose value is a JSON Array ofActivityObjects.
     */
    public List<ActivityObject> getAttachments() {
        return getList("attachments", ActivityObject.FACTORY);
    }

    /**
     * Describes the entity that created or authored the object. An object MAY
     * contain a single author property whose value is an ActivityObject of any
     * type. Note that the author field identifies the entity that created the
     * object and does not necessarily identify the entity that published the
     * object. For instance, it may be the case that an object created by one
     * person is posted and published to a system by an entirely different
     * entity. OpenSocial note: A common use case is for the "author" to be an
     * OpenSocial. Containers SHOULD use the IRI form of the Global-Id as the
     * value.
     */
    public ActivityObject getAuthor() {
        return getValue("author", ActivityObject.FACTORY);
    }

    /**
     * Natural-language description of the object encoded as a single JSON
     * String containing HTML markup. Visual elements such as thumbnail images
     * MAY be included. An object MAY contain a content property.
     */
    public String getContent() {
        return getString("content");
    }

    /**
     * Many social business systems incorporate the idea that an activity may
     * not be public. By including the "deliverTo:" field, a specific user(s)
     * will receive the activity. The Activity MUST be delivered to the
     * recipients specified in the deliverTo: Array
     */
    public List<ObjectId> getDeliverTo() {
        return getList("deliverTo:", ObjectId.FACTORY);
    }

    /**
     * A natural-language, human-readable and plain-text name for the object.
     * HTML markup MUST NOT be included. An object MAY contain a displayName
     * property. If the object does not specify an objectType property, the
     * object SHOULD specify a displayName.
     */
    public String getDisplayName() {
        return getString("displayName");
    }

    /**
     * A JSON Array of one or more absolute IRI's [RFC3987] identifying objects
     * that duplicate this object's content. An object SHOULD contain a
     * downstreamDuplicates property when there are known objects, possibly in a
     * different system, that duplicate the content in this object. This MAY be
     * used as a hint for consumers to use when resolving duplicates between
     * objects received from different sources.
     */
    public List<String> getDownstreamDuplicates() {
        return getList("downstreamDuplicates", JsonValue.STRING_FACTORY);
    }

    /**
     * Returns the ID of this activity object as an {@link ObjectId} instance.
     */
    public ObjectId getId() {
        return getValue("id", GroupId.FACTORY);
    }

    /**
     * Provides a permanent, universally unique identifier for the object in the
     * form of an absolute IRI [RFC3987]. An object SHOULD contain a single id
     * property. If an object does not contain an id property, consumers MAY use
     * the value of the url property as a less-reliable, non-unique identifier.
     */
    public String getIdAsString() {
        return getString("id");
    }

    /**
     * Description of a resource providing a visual representation of the
     * object, intended for human consumption. An object MAY contain an image
     * property whose value is aMediaLink.
     */
    public MediaLink getMediaLink() {
        return getValue("image", MediaLink.FACTORY);
    }

    /**
     * Identifies the type of object. An object MAY contain an objectType
     * property whose value is a JSON String that is non-empty and matches
     * either the "isegment-nz-nc" or the "IRI" production in [RFC3987]. Note
     * that the use of a relative reference other than a simple name is not
     * allowed. If no objectType property is contained, the object has no
     * specific type.
     */
    public String getObjectType() {
        return getString("objectType");
    }

    /**
     * The date and time at which the object was published. An object MAY
     * contain a published property.
     */
    public FormattedDate getPublished() {
        return getDate("published");
    }

    /**
     * Natural-language summarization of the object encoded as a single JSON
     * String containing HTML markup. Visual elements such as thumbnail images
     * MAY be included. An activity MAY contain a summary property.
     */
    public String getSummary() {
        return getString("summary");
    }

    /**
     * The date and time at which a previously published object has been
     * modified. An Object MAY contain an updated property.
     */
    public FormattedDate getUpdated() {
        return getDate("updated");
    }

    /**
     * A JSON Array of one or more absolute IRI's [RFC3987] identifying objects
     * that duplicate this object's content. An object SHOULD contain an
     * upstreamDuplicates property when a publisher is knowingly duplicating
     * with a new ID the content from another object. This MAY be used as a hint
     * for consumers to use when resolving duplicates between objects received
     * from different sources.
     */
    public List<String> getUpstreamDuplicates() {
        return getList("upstreamDuplicates", JsonValue.STRING_FACTORY);
    }

    /**
     * An IRI [RFC3987] identifying a resource providing an HTML representation
     * of the object. An object MAY contain a url property
     */
    public String getUrl() {
        return getString("url");
    }

    /**
     * A collection of one or more additional, associated objects, similar to
     * the concept of attached files in an email message. An object MAY have an
     * attachments property whose value is a JSON Array ofActivityObjects.
     * 
     * @param list
     * @return
     */
    public ActivityObject setAttachments(List<ActivityObject> list) {
        setValue("attachments", list);
        return this;
    }

    /**
     * Describes the entity that created or authored the object. An object MAY
     * contain a single author property whose value is an ActivityObject of any
     * type. Note that the author field identifies the entity that created the
     * object and does not necessarily identify the entity that published the
     * object. For instance, it may be the case that an object created by one
     * person is posted and published to a system by an entirely different
     * entity. OpenSocial note: A common use case is for the "author" to be an
     * OpenSocial. Containers SHOULD use the IRI form of the Global-Id as the
     * value.
     */
    public ActivityObject setAuthor(ActivityObject author) {
        setValue("author", author);
        return this;
    }

    /**
     * Natural-language description of the object encoded as a single JSON
     * String containing HTML markup. Visual elements such as thumbnail images
     * MAY be included. An object MAY contain a content property.
     */
    public ActivityObject setContent(String content) {
        setValue("content", content);
        return this;
    }

    /**
     * Many social business systems incorporate the idea that an activity may
     * not be public. By including the "deliverTo:" field, a specific user(s)
     * will receive the activity. The Activity MUST be delivered to the
     * recipients specified in the deliverTo: Array
     */
    public ActivityObject setDeliverTo(List<ObjectId> list) {
        setValue("deliverTo:", list);
        return this;
    }

    /**
     * A natural-language, human-readable and plain-text name for the object.
     * HTML markup MUST NOT be included. An object MAY contain a displayName
     * property. If the object does not specify an objectType property, the
     * object SHOULD specify a displayName.
     */
    public ActivityObject setDisplayName(String content) {
        setValue("displayName", content);
        return this;
    }

    /**
     * A JSON Array of one or more absolute IRI's [RFC3987] identifying objects
     * that duplicate this object's content. An object SHOULD contain a
     * downstreamDuplicates property when there are known objects, possibly in a
     * different system, that duplicate the content in this object. This MAY be
     * used as a hint for consumers to use when resolving duplicates between
     * objects received from different sources.
     */
    public ActivityObject setDownstreamDuplicates(List<String> list) {
        setValue("downstreamDuplicates", list);
        return this;
    }

    /**
     * Provides a permanent, universally unique identifier for the object in the
     * form of an absolute IRI [RFC3987]. An object SHOULD contain a single id
     * property. If an object does not contain an id property, consumers MAY use
     * the value of the url property as a less-reliable, non-unique identifier.
     */
    public ActivityObject setId(ObjectId id) {
        String strId = id != null ? id.toString() : null;
        setId(strId);
        return this;
    }

    /**
     * Provides a permanent, universally unique identifier for the object in the
     * form of an absolute IRI [RFC3987]. An object SHOULD contain a single id
     * property. If an object does not contain an id property, consumers MAY use
     * the value of the url property as a less-reliable, non-unique identifier.
     */
    public ActivityObject setId(String id) {
        setValue("id", id);
        return this;
    }

    /**
     * Description of a resource providing a visual representation of the
     * object, intended for human consumption. An object MAY contain an image
     * property whose value is aMediaLink.
     */
    public ActivityObject setMediaLink(MediaLink link) {
        setValue("image", link);
        return this;
    }

    /**
     * Identifies the type of object. An object MAY contain an objectType
     * property whose value is a JSON String that is non-empty and matches
     * either the "isegment-nz-nc" or the "IRI" production in [RFC3987]. Note
     * that the use of a relative reference other than a simple name is not
     * allowed. If no objectType property is contained, the object has no
     * specific type.
     */
    public ActivityObject setObjectType(String id) {
        setValue("objectType", id);
        return this;
    }

    /**
     * The date and time at which the object was published. An object MAY
     * contain a published property.
     */
    public ActivityObject setPublished(FormattedDate date) {
        setValue("published", date);
        return this;
    }

    /**
     * Natural-language summarization of the object encoded as a single JSON
     * String containing HTML markup. Visual elements such as thumbnail images
     * MAY be included. An activity MAY contain a summary property.
     */
    public ActivityObject setSummary(String summary) {
        setValue("summary", summary);
        return this;
    }

    /**
     * The date and time at which a previously published object has been
     * modified. An Object MAY contain an updated property.
     */
    public ActivityObject setUpdated(FormattedDate date) {
        setValue("updated", date);
        return this;
    }

    /**
     * A JSON Array of one or more absolute IRI's [RFC3987] identifying objects
     * that duplicate this object's content. An object SHOULD contain an
     * upstreamDuplicates property when a publisher is knowingly duplicating
     * with a new ID the content from another object. This MAY be used as a hint
     * for consumers to use when resolving duplicates between objects received
     * from different sources.
     */
    public ActivityObject setUpstreamDuplicates(List<String> list) {
        setValue("upstreamDuplicates", list);
        return this;
    }

    /**
     * An IRI [RFC3987] identifying a resource providing an HTML representation
     * of the object. An object MAY contain a url property
     */
    public ActivityObject setUrl(String url) {
        setValue("url", url);
        return this;
    }

}

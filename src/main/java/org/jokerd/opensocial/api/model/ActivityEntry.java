package org.jokerd.opensocial.api.model;

import java.util.List;

import org.ubimix.commons.json.ext.FormattedDate;

/**
 * In its simplest form, an activity consists of an actor, a verb, an an object,
 * and a target. It tells the story of a person performing an action on or with
 * an object -- "Geraldine posted a photo to her album" or
 * "John shared a video". OpenSocial adds an additional field to the data model,
 * "actionLinks". Because these are extensions, they are contained in an
 * enclosing namespace, "openSocial".
 * 
 * <pre>
 * {
 *   provider: {
 *     url: "http://example.org/activity-stream"
 *   },
 *   object: {
 *     summary: "Photo posted",
 *     image: {
 *       height: 250,
 *       width: 250,
 *       url: "http://example.org/album/my_fluffy_cat_thumb.jpg"
 *     },
 *     downstreamDuplicates: [
 *       "downstream1",
 *       "downstream2"
 *     ],
 *     url: "http://example.org/album/my_fluffy_cat.jpg",
 *     id: "object2",
 *     upstreamDuplicates: [
 *       "upstream1",
 *       "upstream2"
 *     ],
 *     attachments: [
 *       {
 *         id: "attachment1",
 *         objectType: "attachment"
 *       },
 *       {
 *         id: "attachment2",
 *         objectType: "attachment"
 *       }
 *     ],
 *     objectType: "photo"
 *   },
 *   actor: {
 *     image: {
 *       height: 250,
 *       width: 250,
 *       url: "http://example.org/martin/image"
 *     },
 *     url: "http://example.org/john",
 *     id: "john.doe",
 *     displayName: "John Doe",
 *     objectType: "person"
 *   },
 *   id: "activity2",
 *   title: "John posted a new video to his album.",
 *   verb: "post",
 *   target: {
 *     image: {
 *       height: 250,
 *       width: 250,
 *       url: "http://example.org/album/thumbnail.jpg"
 *     },
 *     url: "http://example.org/album/",
 *     id: "target2",
 *     displayName: "John's Photo Album",
 *     objectType: "photo-album"
 *   },
 *   generator: {
 *     url: "http://example.org/activities-app"
 *   },
 *   published: "2011-02-10T15:04:55Z",
 *   openSocial: {
 *     actionLinks:[{
 *       caption: "Add Friend",
 *       target: "http://example.org/friends/jane.doe",
 *       httpVerb: "POST"
 *     }]
 *   }
 * }
 * </pre>
 * 
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/2.0.1/Social-Data.xml#ActivityEntry
public class ActivityEntry extends DataObject {

    public static IJsonValueFactory<ActivityEntry> FACTORY = new IJsonValueFactory<ActivityEntry>() {
        @Override
        public ActivityEntry newValue(Object object) {
            return new ActivityEntry().setJsonObject(object);
        }
    };

    /**
     * An "openSocial" namespaced array of actionLinks associated with this
     * Activity.
     */
    public List<ActionLink> getActionLinks() {
        return getList("actionLinks", ActionLink.FACTORY);
    }

    /**
     * Describes the entity that performed the activity. An activity MUST
     * contain one actor property whose value is a single ActivityObject.
     */
    public ActivityObject getActor() {
        return getValue("actor", ActivityObject.FACTORY);
    }

    /**
     * Natural-language description of the activity encoded as a single JSON
     * String containing HTML markup. Visual elements such as thumbnail images
     * MAY be included. An activity MAY contain a content property.
     */
    public String getContent() {
        return getString("content");
    }

    /**
     * Describes the application that generated the activity. An activity MAY
     * contain a generator property whose value is a single ActivityObject.
     * OpenSocial note: If an OpenSocial application created the Activity Entry,
     * this value SHOULD be the appId (Section 3.6).
     */
    public ActivityObject getGenerator() {
        return getGenerator(ActivityObject.FACTORY);
    }

    /**
     * Describes the application that generated the activity. An activity MAY
     * contain a generator property whose value is a single ActivityObject.
     * OpenSocial note: If an OpenSocial application created the Activity Entry,
     * this value SHOULD be the appId (Section 3.6).
     */
    public <T extends ActivityObject> T getGenerator(
        IJsonValueFactory<T> factory) {
        return getValue("generator", factory);
    }

    /**
     * Description of a resource providing a visual representation of the
     * object, intended for human consumption. The image SHOULD have an aspect
     * ratio of one (horizontal) to one (vertical) and SHOULD be suitable for
     * presentation at a small size. An activity MAY have an icon property.
     */
    public MediaLink getIcon() {
        return getValue("icon", MediaLink.FACTORY);
    }

    /**
     * Provides a permanent, universally unique identifier for the activity in
     * the form of an absolute IRI. An activity SHOULD contain a single id
     * property. If an activity does not contain an id property, consumers MAY
     * use the value of the url property as a less-reliable, non-unique
     * identifier. OpenSocial note: The value of id MUST be the IRI form of the
     * Global-Id.
     */
    public ObjectId getId() {
        String str = getIdAsString();
        return ObjectId.FACTORY.newValue(str);
    }

    /**
     * Provides a permanent, universally unique identifier for the activity in
     * the form of an absolute IRI. An activity SHOULD contain a single id
     * property. If an activity does not contain an id property, consumers MAY
     * use the value of the url property as a less-reliable, non-unique
     * identifier. OpenSocial note: The value of id MUST be the IRI form of the
     * Global-Id.
     */
    public String getIdAsString() {
        return getString("id");
    }

    /**
     * Describes the primary object of the activity. For instance, in the
     * activity, "John saved a movie to his wishlist", the object of the
     * activity is "movie". An activity SHOULD contain an object property whose
     * value is a single Object. If the object property is not contained, the
     * primary object of the activity MAY be implied by context.
     */
    public ActivityObject getObject() {
        return getObject(ActivityObject.FACTORY);
    }

    /**
     * Describes the primary object of the activity. For instance, in the
     * activity, "John saved a movie to his wishlist", the object of the
     * activity is "movie". An activity SHOULD contain an object property whose
     * value is a single Object. If the object property is not contained, the
     * primary object of the activity MAY be implied by context.
     */
    public <T extends ActivityObject> T getObject(IJsonValueFactory<T> factory) {
        return getValue("object", factory);
    }

    /**
     * Describes the application that published the activity. Note that this is
     * not necessarily the same entity that generated the activity. An activity
     * MAY contain a provider property whose value is a single ActivityObject.
     * OpenSocial note: The provider SHOULD be URL of the domain part of the
     * Global-Id plus the OpenSocial service. Example:
     * http://mySocialNetwork.com/activitystreams
     */
    public ActivityObject getProvider() {
        return getProvider(ActivityObject.FACTORY);
    }

    /**
     * Describes the application that published the activity. Note that this is
     * not necessarily the same entity that generated the activity. An activity
     * MAY contain a provider property whose value is a single ActivityObject.
     * OpenSocial note: The provider SHOULD be URL of the domain part of the
     * Global-Id plus the OpenSocial service. Example:
     * http://mySocialNetwork.com/activitystreams
     */
    public <T extends ActivityObject> T getProvider(IJsonValueFactory<T> factory) {
        return getValue("provider", factory);
    }

    /**
     * The date and time at which the activity was published. An activity MUST
     * contain a published property.
     */
    public FormattedDate getPublished() {
        return getDate("published");
    }

    /**
     * Describes the target of the activity. The precise meaning of the
     * activity's target is dependent on the activities verb, but will often be
     * the object the English preposition "to". For instance, in the activity,
     * "John saved a movie to his wishlist", the target of the activity is
     * "wishlist". The activity target MUST NOT be used to identity an indirect
     * object that is not a target of the activity. An activity MAY contain a
     * target property whose value is a single ActivityObject.
     */
    public ActivityObject getTarget() {
        return getTarget(ActivityObject.FACTORY);
    }

    /**
     * Describes the target of the activity. The precise meaning of the
     * activity's target is dependent on the activities verb, but will often be
     * the object the English preposition "to". For instance, in the activity,
     * "John saved a movie to his wishlist", the target of the activity is
     * "wishlist". The activity target MUST NOT be used to identity an indirect
     * object that is not a target of the activity. An activity MAY contain a
     * target property whose value is a single ActivityObject.
     */
    public <T extends ActivityObject> T getTarget(IJsonValueFactory<T> factory) {
        return getValue("target", factory);
    }

    /**
     * Natural-language title or headline for the activity encoded as a single
     * JSON String containing HTML markup. An activity MAY contain a title
     * property.
     */
    public String getTitle() {
        return getString("title");
    }

    /**
     * The date and time at which a previously published activity has been
     * modified. An Activity MAY contain an updated property.
     */
    public FormattedDate getUpdated() {
        return getDate("updated");
    }

    /**
     * An IRI identifying a resource providing an HTML representation of the
     * activity. An activity MAY contain a url property.
     */
    public String getUrl() {
        return getString("url");
    }

    /**
     * Identifies the action that the activity describes. An activity SHOULD
     * contain a verb property whose value is a JSON String that is non-empty
     * and matches either the "isegment-nz-nc" or the "IRI" production in
     * RFC3339. Note that the use of a relative reference other than a simple
     * name is not allowed. If the verb is not specified, or if the value is
     * null, the verb is assumed to be "post".
     */
    public String getVerb() {
        return getString("verb");
    }

    /**
     * An "openSocial" namespaced array of actionLinks associated with this
     * Activity.
     */
    public ActivityEntry setActionLinks(List<ActionLink> value) {
        setValue("actionLinks", value);
        return this;
    }

    /**
     * Describes the entity that performed the activity. An activity MUST
     * contain one actor property whose value is a single ActivityObject.
     */
    public ActivityEntry setActor(ActivityObject actor) {
        setValue("actor", actor);
        return this;
    }

    /**
     * Natural-language description of the activity encoded as a single JSON
     * String containing HTML markup. Visual elements such as thumbnail images
     * MAY be included. An activity MAY contain a content property.
     */
    public ActivityEntry setContent(String content) {
        setValue("content", content);
        return this;
    }

    /**
     * Describes the application that generated the activity. An activity MAY
     * contain a generator property whose value is a single ActivityObject.
     * OpenSocial note: If an OpenSocial application created the Activity Entry,
     * this value SHOULD be the appId (Section 3.6).
     */
    public ActivityEntry setGenerator(ActivityObject generator) {
        setValue("generator", generator);
        return this;
    }

    /**
     * Provides a permanent, universally unique identifier for the activity in
     * the form of an absolute IRI. An activity SHOULD contain a single id
     * property. If an activity does not contain an id property, consumers MAY
     * use the value of the url property as a less-reliable, non-unique
     * identifier. OpenSocial note: The value of id MUST be the IRI form of the
     * Global-Id.
     */
    public ActivityEntry setId(String id) {
        setValue("id", id);
        return this;
    }

    /**
     * Description of a resource providing a visual representation of the
     * object, intended for human consumption. The image SHOULD have an aspect
     * ratio of one (horizontal) to one (vertical) and SHOULD be suitable for
     * presentation at a small size. An activity MAY have an icon property.
     */
    public ActivityEntry setMediaLink(MediaLink link) {
        setValue("icon", link);
        return this;
    }

    /**
     * Describes the primary object of the activity. For instance, in the
     * activity, "John saved a movie to his wishlist", the object of the
     * activity is "movie". An activity SHOULD contain an object property whose
     * value is a single Object. If the object property is not contained, the
     * primary object of the activity MAY be implied by context.
     */
    public ActivityEntry setObject(ActivityObject object) {
        setValue("object", object);
        return this;
    }

    /**
     * Describes the application that published the activity. Note that this is
     * not necessarily the same entity that generated the activity. An activity
     * MAY contain a provider property whose value is a single ActivityObject.
     * OpenSocial note: The provider SHOULD be URL of the domain part of the
     * Global-Id plus the OpenSocial service. Example:
     * http://mySocialNetwork.com/activitystreams
     */
    public ActivityEntry setProvider(ActivityObject provider) {
        setValue("provider", provider);
        return this;
    }

    /**
     * The date and time at which the activity was published. An activity MUST
     * contain a published property.
     */
    public ActivityEntry setPublished(FormattedDate date) {
        setValue("published", date);
        return this;
    }

    /**
     * Describes the target of the activity. The precise meaning of the
     * activity's target is dependent on the activities verb, but will often be
     * the object the English preposition "to". For instance, in the activity,
     * "John saved a movie to his wishlist", the target of the activity is
     * "wishlist". The activity target MUST NOT be used to identity an indirect
     * object that is not a target of the activity. An activity MAY contain a
     * target property whose value is a single ActivityObject.
     */
    public ActivityEntry setTarget(ActivityObject target) {
        setValue("target", target);
        return this;
    }

    /**
     * Natural-language title or headline for the activity encoded as a single
     * JSON String containing HTML markup. An activity MAY contain a title
     * property.
     */
    public ActivityEntry setTitle(String value) {
        setValue("title", value);
        return this;
    }

    /**
     * The date and time at which a previously published activity has been
     * modified. An Activity MAY contain an updated property.
     */
    public ActivityEntry setUpdated(FormattedDate date) {
        setValue("updated", date);
        return this;
    }

    /**
     * An IRI identifying a resource providing an HTML representation of the
     * activity. An activity MAY contain a url property.
     */
    public ActivityEntry setUrl(String value) {
        setValue("url", value);
        return this;
    }

    /**
     * Identifies the action that the activity describes. An activity SHOULD
     * contain a verb property whose value is a JSON String that is non-empty
     * and matches either the "isegment-nz-nc" or the "IRI" production in
     * RFC3339. Note that the use of a relative reference other than a simple
     * name is not allowed. If the verb is not specified, or if the value is
     * null, the verb is assumed to be "post".
     */
    public ActivityEntry setVerb(String value) {
        setValue("verb", value);
        return this;
    }

}

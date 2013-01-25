/**
 * 
 */
package org.jokerd.opensocial.api.model;

/**
 * Some types of objects may have an alternative visual representation in the
 * form of an image, video or embedded HTML fragments. A Media Link represents a
 * hyperlink to such resources.
 * 
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/2.0.1/Social-Data.xml#MediaLink
public class MediaLink extends DataObject {

    public static IJsonValueFactory<MediaLink> FACTORY = new IJsonValueFactory<MediaLink>() {
        public MediaLink newValue(Object object) {
            return new MediaLink().setJsonObject(object);
        }
    };

    /**
     * 
     */
    public MediaLink() {
    }

    /**
     * @param object
     */
    public MediaLink(Object object) {
        super(object);
    }

    /**
     * A hint to the consumer about the length, in seconds, of the media
     * resource identified by the url property. A media link MAY contain a
     * "duration" property when the target resource is a time-based media item
     * such as an audio or video.
     */
    public int getDuration() {
        return getInteger("duration", -1);
    }

    /**
     * A hint to the consumer about the height, in pixels, of the media resource
     * identified by the url property. A media link MAY contain a height
     * property when the target resource is a visual media item such as an
     * image, video or embeddable HTML page.
     */
    public int getHeight() {
        return getInteger("height", 0);
    }

    /**
     * Provides a mapping from an Activity Streams MediaLink to an
     * OpenSocialMediaItem. Identifies the corresponding MediaItem that this
     * MediaLink maps to, if any. This field is namespaced as an "openSocial"
     * extension. Optional.
     */
    public String getMediaItemId() {
        return getString("mediaItemId");
    }

    /**
     * The IRI of the media resource being linked. A media link MUST have a url
     * property. OpenSocial note: Many OpenSocial containers currently use Media
     * Items as defined by this specification. When a container creates a Media
     * Link that is based on a Media Item, the Media Link URL MUST match the URL
     * of the Media Item.
     */
    public String getUrl() {
        return getString("url");
    }

    /**
     * A hint to the consumer about the width, in pixels, of the media resource
     * identified by the url property. A media link MAY contain a width property
     * when the target resource is a visual media item such as an image, video
     * or embeddable HTML page.
     */
    public int getWidth() {
        return getInteger("width", 0);
    }

    /**
     * A hint to the consumer about the length, in seconds, of the media
     * resource identified by the url property. A media link MAY contain a
     * "duration" property when the target resource is a time-based media item
     * such as an audio or video.
     */
    public MediaLink setDuration(int duration) {
        setValue("duration", duration);
        return this;
    }

    /**
     * A hint to the consumer about the height, in pixels, of the media resource
     * identified by the url property. A media link MAY contain a height
     * property when the target resource is a visual media item such as an
     * image, video or embeddable HTML page.
     */
    public MediaLink setHeight(int value) {
        setValue("height", value);
        return this;
    }

    /**
     * Provides a mapping from an Activity Streams MediaLink to an
     * OpenSocialMediaItem. Identifies the corresponding MediaItem that this
     * MediaLink maps to, if any. This field is namespaced as an "openSocial"
     * extension. Optional.
     */
    public MediaLink setMediaItemId(String mediaItemId) {
        setValue("mediaItemId", mediaItemId);
        return this;
    }

    /**
     * The IRI of the media resource being linked. A media link MUST have a url
     * property. OpenSocial note: Many OpenSocial containers currently use Media
     * Items as defined by this specification. When a container creates a Media
     * Link that is based on a Media Item, the Media Link URL MUST match the URL
     * of the Media Item.
     */

    public MediaLink setUrl(String url) {
        setValue("url", url);
        return this;
    }

    /**
     * A hint to the consumer about the width, in pixels, of the media resource
     * identified by the url property. A media link MAY contain a width property
     * when the target resource is a visual media item such as an image, video
     * or embeddable HTML page.
     */
    public MediaLink setWidth(int value) {
        setValue("width", value);
        return this;
    }
}

/**
 * 
 */
package org.jokerd.opensocial.api.model;

import org.ubimix.commons.json.JsonValue;

/**
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/1.0/Social-Data.xml#MediaItem
public class MediaItem extends DataObject {

    public static class Type {

        public static final IJsonValueFactory<Type> FACTORY = new IJsonValueFactory<Type>() {
            @Override
            public Type newValue(Object object) {
                String str = JsonValue.STRING_FACTORY.newValue(object);
                return new Type(str);
            }
        };

        protected final String fType;

        /**
         * @param type
         */
        public Type(String type) {
            fType = type;
        }

        @Override
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Type)) {
                return false;
            }
            Type o = (Type) obj;
            return fType.equals(o.fType);
        }

        protected final String getType() {
            return fType;
        }

        @Override
        public final int hashCode() {
            return fType.hashCode();
        }

        @Override
        public final String toString() {
            return fType;
        }

    }

    public static IJsonValueFactory<MediaItem> FACTORY = new IJsonValueFactory<MediaItem>() {
        @Override
        public MediaItem newValue(Object object) {
            return new MediaItem().setJsonObject(object);
        }
    };

    public final static MediaItem.Type TYPE_AUDIO = new MediaItem.Type("audio");

    public final static MediaItem.Type TYPE_IMAGE = new MediaItem.Type("image");

    public final static MediaItem.Type TYPE_VIDEO = new MediaItem.Type("video");

    /**
     * Returns the identifier of the album to which the media item belongs.
     */
    public ObjectId getAlbumId() {
        return getValue("album_id", ObjectId.FACTORY);
    }

    /**
     * Returns the media item's description if set.
     */
    public String getDescription() {
        return getString("description");
    }

    /**
     * Returns the media item's associated ID.
     */
    public ObjectId getId() {
        return getValue("id", ObjectId.FACTORY);
    }

    /**
     * Returns the MIME type of the media item's content.
     */
    public String getMimeType() {
        return getString("mime_type");
    }

    /**
     * Returns the URL of the media item's thumbnail image as a string.
     */
    public String getThumbnailUrl() {
        String str = getString("thumbnailUrl");
        if (str == null) {
            str = getString("thumbnail_url");
        }
        return str;
    }

    /**
     * Returns the media item's caption if set.
     */
    public String getTitle() {
        String str = getString("title");
        if (str == null) {
            str = getString("caption");
        }
        return str;
    }

    /**
     * Returns the type of media, specified as a MediaItem.Type object. One of
     * 'audio', 'image', or 'video'.
     */
    public MediaItem.Type getType() {
        return getValue("type", MediaItem.Type.FACTORY);
    }

    /**
     * Returns the URL where the media can be found as a string.
     */
    public String getUrl() {
        return getString("url");
    }

    /**
     * Sets the identifier of the album to which the media item belongs.
     * 
     * @param albumId ID of album intended to contain media item
     */
    public void setAlbumId(ObjectId albumId) {
        setValue("album_id", albumId);
    }

    /**
     * Sets the media item's description.
     * 
     * @param description description to set
     */
    public void setDescription(String description) {
        setValue("description", description);
    }

    /**
     * Sets the media item's unique identifier. Required when updating an
     * existing media item; the container generates the identifier when a new
     * media item is created.
     * 
     * @param id identifier to set
     */
    public void setId(ObjectId id) {
        setValue("id", id);
    }

    /**
     * Sets the MIME type of the media item's content.
     * 
     * @param mimeType MIME type to set
     */
    public void setMimeType(String mimeType) {
        setValue("mime_type", mimeType);
    }

    /**
     * Sets the URL of the media item's thumbnail image as a string.
     * 
     * @param thumbnailUrl URL of media item thumbnail to set
     */
    public void setThumbnailUrl(String thumbnailUrl) {
        setValue("thumbnail_url", thumbnailUrl);
    }

    /**
     * Sets the media item's caption/title.
     * 
     * @param title caption/title to set
     */
    public void setTitle(String title) {
        setValue("title", title);
    }

    /**
     * Sets the media item's type.
     * 
     * @param type type to set; must be 'audio', 'image', or 'video'
     */
    public void setType(MediaItem.Type type) {
        setValue("type", type);
    }

    /**
     * Sets the URL where the media can be found.
     * 
     * @param url URL to set
     */
    public void setUrl(String url) {
        setValue("url", url);
    }

}

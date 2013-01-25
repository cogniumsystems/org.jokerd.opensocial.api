package org.jokerd.opensocial.api.model;

import java.util.List;

/**
 * Albums support collections of media items (video, image, sound).
 * 
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/2.0.1/Social-Data.xml#Album
public class Album extends DataObject {

    public static IJsonValueFactory<Album> FACTORY = new IJsonValueFactory<Album>() {
        public Album newValue(Object object) {
            return new Album().setJsonObject(object);
        }
    };

    /**
     * Returns the album's caption or title.
     */
    public String getCaption() {
        return getString("caption");
    }

    /**
     * Returns the album's description.
     */
    public String getDescription() {
        return getString("description");
    }

    /**
     * Returns the album's unique identifier.
     */
    public ObjectId getId() {
        return getValue("id", ObjectId.FACTORY);
    }

    /**
     * Location corresponding to the album.
     */
    public Address getLocation() {
        return getValue("location", Address.FACTORY);
    }

    /**
     * Number of items in the album.
     */
    public int getMediaItemCount() {
        return getInteger("mediaItemCount", 0);
    }

    /**
     * Array of strings identifying the mime-types of media items in the Album.
     */
    public List<String> getMediaMimeType() {
        return getList("mediaMimeType", STRING_FACTORY);
    }

    /**
     * Array of MediaItem types, types are one of: audio, image, video.
     */
    public List<String> getMediaType() {
        return getList("mediaType", STRING_FACTORY);
    }

    /**
     * ID of the owner of the album.
     */
    public ObjectId getOwernId() {
        return getValue("owernId", ObjectId.FACTORY);
    }

    /**
     * Returns the OpenSocial ID of the album's owner.
     */
    public UserId getOwnerId() {
        return getValue("ownerId", UserId.FACTORY);
    }

    /**
     * Returns the album cover's thumbnail URL as a string.
     */
    public String getThumbnailUrl() {
        return getString("thumbnailUrl");
    }

    /**
     * the title of the album.
     */
    public String getTitle() {
        return getString("title");
    }

    /**
     * Sets the album's caption or title.
     * 
     * @param caption caption to set
     */
    public void setCaption(String caption) {
        setValue("caption", caption);
    }

    /**
     * Sets the album's description.
     * 
     * @param description description to set
     */
    public void setDescription(String description) {
        setValue("description", description);
    }

    /**
     * Sets the album's unique identifier. Required when updating an existing
     * album; the container generates the identifier when a new album is
     * created.
     * 
     * @param id identifier to set
     */
    public void setId(ObjectId id) {
        setValue("id", id);
    }

    /**
     * Location corresponding to the album.
     */
    public Album setLocation(Address value) {
        setValue("location", value);
        return this;
    }

    /**
     * Number of items in the album.
     */
    public Album setMediaItemCount(int value) {
        setValue("mediaItemCount", value);
        return this;
    }

    /**
     * Array of strings identifying the mime-types of media items in the Album.
     */
    public Album setMediaMimeType(List<String> values) {
        setValue("mediaMimeType", values);
        return this;
    }

    /**
     * Array of strings identifying the mime-types of media items in the Album.
     */
    public Album setMediaMimeType(String... values) {
        setValue("mediaMimeType", values);
        return this;
    }

    /**
     * Array of MediaItem types, types are one of: audio, image, video.
     */
    public Album setMediaType(List<String> values) {
        setValue("mediaType", values);
        return this;
    }

    /**
     * Array of MediaItem types, types are one of: audio, image, video.
     */
    public Album setMediaType(String... values) {
        setValue("mediaType", values);
        return this;
    }

    /**
     * ID of the owner of the album.
     */
    public Album setOwernId(ObjectId value) {
        setValue("owernId", value);
        return this;
    }

    /**
     * Sets the album cover's thumbnail URL.
     * 
     * @param thumbnailUrl URL of album cover thumbnail to set
     */
    public void setThumbnailUrl(String thumbnailUrl) {
        setValue("thumbnailUrl", thumbnailUrl);
    }

    /**
     * the title of the album.
     */
    public Album setTitle(String value) {
        setValue("title", value);
        return this;
    }
}

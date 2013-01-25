package org.jokerd.opensocial.api.model;

import java.util.Comparator;
import java.util.List;

import org.ubimix.commons.json.JsonValue;
import org.ubimix.commons.json.ext.FormattedDate;

/**
 * Valid definitions for Message-Field are listed in the table below.
 * <p>
 * A Message example follows. For brevity, details of the 'sender' field, an
 * OpenSocial Person, are omitted.
 * </p>
 * 
 * <pre>
 *  application/json representation
 *  
 *  {
 *   "id" : "http://example.org/inbox/message/{msgid}",
 *    "recipients" : ["example.org:AD38B3886625AAF", "example.org:997638BAA6F25AD"],
 *   "sender" : "{ "id" : ... }",
 *   "title" : "You have a new messge from Joe",
 *   "titleId" : "541141091700",
 *   "body" : "Short message from Joe to some friend\/s",
 *   "bodyId" : "5491155811231",  
 *   "type" : "privateMessage",
 *   "status" : "unread",
 *   "data" : "..."
 *  }
 * </pre>
 * 
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/2.0.1/Social-Data.xml#Message
public class Message extends ActivityObject implements Comparable<Message> {

    public static Comparator<? super Message> COMPARATOR = new Comparator<Message>() {
        @Override
        public int compare(Message o1, Message o2) {
            FormattedDate first = o1.getUpdated();
            FormattedDate second = o2.getUpdated();
            return -first.compareTo(second);
        }
    };

    public static IJsonValueFactory<Message> FACTORY = new IJsonValueFactory<Message>() {
        @Override
        public Message newValue(Object object) {
            return new Message().setJsonObject(object);
        }
    };

    @Override
    public int compareTo(Message o) {
        return COMPARATOR.compare(this, o);
    }

    /** Identifies the application that generated this message. */
    public String getAppUrl() {
        return getString("appUrl");
    }

    /**
     * The main text of the message. HTML attributes are allowed and are
     * sanitized by the container.
     */
    public String getBody() {
        return getString("body");
    }

    /**
     * The main text of the message as a message template. Specifies the message
     * ID to use in the gadget xml.
     */
    public String getBodyId() {
        return getString("bodyId");
    }

    /** Identifies the messages collection IDs this message is contained in. */
    public List<String> getCollectionIds() {
        return getList("collectionIds", JsonValue.STRING_FACTORY);
    }

    /** Unique ID for this message. */
    @Override
    public ObjectId getId() {
        return getValue("id", ObjectId.FACTORY);
    }

    /**
     * Message ID, use for threaded comments/messages. Reference the sematics of
     * the Atom Threading model defined in rfc4685. URLs should be mapped to
     * Atom <link rel="type" .../>
     */
    public ObjectId getInReplyTo() {
        return getValue("inReplyTo", ObjectId.FACTORY);
    }

    /** Array of person IDs. */
    public List<UserId> getRecipients() {
        return getList("recipients", UserId.FACTORY);
    }

    /**
     * Array of message ids. Reference the sematics of the Atom Threading model
     * defined in rfc4685. URLs should be mapped to Atom <link rel="type" .../>
     */
    public List<ObjectId> getReplies() {
        return getList("replies", ObjectId.FACTORY);
    }

    /** Id of person who sent the message. */
    public UserId getSenderId() {
        return getValue("senderId", UserId.FACTORY);
    }

    /** Status of the message. (NEW, READ, DELETED). */
    public String getStatus() {
        return getString("status");
    }

    /** UTC time message was sent. */
    public FormattedDate getTimeSent() {
        return getValue("timeSent", FormattedDate.FACTORY);
    }

    /**
     * The title of the message. HTML attributes are allowed and are sanitized
     * by the container.
     */
    public String getTitle() {
        return getString("title");
    }

    /**
     * The title of the message as a message template. Specifies the message ID
     * to use in the gadget xml.
     */
    public ObjectId getTitleId() {
        return getValue("titleId", ObjectId.FACTORY);
    }

    /** The title of the message. */
    public String getType() {
        return getString("type");
    }

    /** Last update for this message. */
    @Override
    public FormattedDate getUpdated() {
        return getValue("updated", FormattedDate.FACTORY);
    }

    /**
     * List of related URLs for this message. Supported URL types include
     * 'alternate', alternate for for this mailbox (text/html being the most
     * common).
     */
    public PluralFields<String> getUrls() {
        return getPluralFields("urls", JsonValue.STRING_FACTORY);
    }

    /** Identifies the application that generated this message. */
    public Message setAppUrl(String value) {
        setValue("appUrl", value);
        return this;
    }

    /**
     * The main text of the message. HTML attributes are allowed and are
     * sanitized by the container.
     */
    public Message setBody(String value) {
        setValue("body", value);
        return this;
    }

    /**
     * The main text of the message as a message template. Specifies the message
     * ID to use in the gadget xml.
     */
    public Message setBodyId(String value) {
        setValue("bodyId", value);
        return this;
    }

    /** Identifies the messages collection IDs this message is contained in. */
    public Message setCollectionIds(List<String> values) {
        setValue("collectionIds", values);
        return this;
    }

    /** Identifies the messages collection IDs this message is contained in. */
    public Message setCollectionIds(String... values) {
        setValue("collectionIds", values);
        return this;
    }

    /** Unique ID for this message. */
    @Override
    public Message setId(ObjectId value) {
        setValue("id", value);
        return this;
    }

    @Override
    public Message setId(String value) {
        setId(new ObjectId(value));
        return this;
    }

    /**
     * Message ID, use for threaded comments/messages. Reference the sematics of
     * the Atom Threading model defined in rfc4685. URLs should be mapped to
     * Atom <link rel="type" .../>
     */
    public Message setInReplyTo(ObjectId value) {
        setValue("inReplyTo", value);
        return this;
    }

    /** Array of person IDs. */
    public Message setRecipients(List<UserId> values) {
        setValue("recipients", values);
        return this;
    }

    /** Array of person IDs. */
    public Message setRecipients(UserId... values) {
        setValue("recipients", values);
        return this;
    }

    /**
     * Array of message ids. Reference the sematics of the Atom Threading model
     * defined in rfc4685. URLs should be mapped to Atom <link rel="type" .../>
     */
    public Message setReplies(List<ObjectId> values) {
        setValue("replies", values);
        return this;
    }

    /**
     * Array of message ids. Reference the sematics of the Atom Threading model
     * defined in rfc4685. URLs should be mapped to Atom <link rel="type" .../>
     */
    public Message setReplies(ObjectId... values) {
        setValue("replies", values);
        return this;
    }

    /** Id of person who sent the message. */
    public Message setSenderId(UserId value) {
        setValue("senderId", value);
        return this;
    }

    /** Status of the message. (NEW, READ, DELETED). */
    public Message setStatus(String value) {
        setValue("status", value);
        return this;
    }

    /** UTC time message was sent. */
    public Message setTimeSent(FormattedDate value) {
        setValue("timeSent", value);
        return this;
    }

    /**
     * The title of the message. HTML attributes are allowed and are sanitized
     * by the container.
     */
    public Message setTitle(String value) {
        setValue("title", value);
        return this;
    }

    /**
     * The title of the message as a message template. Specifies the message ID
     * to use in the gadget xml.
     */
    public Message setTitleId(ObjectId value) {
        setValue("titleId", value);
        return this;
    }

    /** The title of the message. */
    public Message setType(String value) {
        setValue("type", value);
        return this;
    }

    /** Last update for this message. */
    @Override
    public Message setUpdated(FormattedDate value) {
        setValue("updated", value);
        return this;
    }

    /**
     * List of related URLs for this message. Supported URL types include
     * 'alternate', alternate for for this mailbox (text/html being the most
     * common).
     */
    public Message setUrls(List<String> values) {
        setValue("urls", values);
        return this;
    }

    /**
     * List of related URLs for this message. Supported URL types include
     * 'alternate', alternate for for this mailbox (text/html being the most
     * common).
     */
    public Message setUrls(String... values) {
        setValue("urls", values);
        return this;
    }

}
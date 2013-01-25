package org.jokerd.opensocial.api.model;

/**
 * OpenSocial Groups are owned by people, and are used to tag or categorize
 * people and their relationships. Each group has a display name, an identifier
 * which is unique within the groups owned by that person, and a URI link. A
 * group may be a private, invitation-only, public or a personal group used to
 * organize friends.
 * 
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/2.0.1/Social-Data.xml#Group
@RequiredField(name = { "id", "title" })
public class Group extends ActivityObject {

    public static IJsonValueFactory<Group> FACTORY = new IJsonValueFactory<Group>() {
        public Group newValue(Object object) {
            return new Group().setJsonObject(object);
        }
    };

    public Group() {
        setObjectType("group");
    }

    /**
     * Description of group Optional.
     */
    public String getDescription() {
        return getString("description");
    }

    /**
     * Returns the group unique identifier.
     */
    @Override
    public GroupId getId() {
        String strId = getIdAsString();
        GroupId id = GroupId.FACTORY.newValue(strId);
        return id;
    }

    /**
     * Returns the group's title.
     */
    public String getTitle() {
        return getString("title");
    }

    /**
     * Description of group Optional.
     */
    public Group setDescription(String value) {
        setValue("description", value);
        return this;
    }

    /**
     * Sets the group's ID
     * 
     * @param id ID to set
     */
    public void setId(GroupId id) {
        super.setId(id);
    }

    /**
     * Sets the group's title
     * 
     * @param title title to set
     */
    public void setTitle(String title) {
        setValue("title", title);
    }

}

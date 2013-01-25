/**
 * 
 */
package org.jokerd.opensocial.api.events;

import java.util.List;

import org.jokerd.opensocial.api.model.Collection;
import org.jokerd.opensocial.api.model.GroupId;
import org.jokerd.opensocial.api.model.Person;
import org.jokerd.opensocial.api.model.UserId;
import org.ubimix.commons.json.JsonValue;

/**
 * @author kotelnikov
 */
public class People extends Service {

    public static class Get extends ServiceCall {

        public Get() {
            this(UserId.ME);
        }

        public Get(String userId) {
            setUserId(new UserId(userId));
            setEscapeType("htmlEscape");
        }

        public Get(UserId userId) {
            setUserId(userId);
        }

        public String getEscapeType() {
            return getRequest().getString("escapeType");
        }

        public List<String> getFieldIds() {
            return getRequest().getList("fields", JsonValue.STRING_FACTORY);
        }

        public GroupId getGroupId() {
            return getRequest().getValue("groupId", GroupId.FACTORY);
        }

        public Collection<Person> getResultPeople() {
            return getResultObject(Collection
                .getCollectionFactory(Person.FACTORY));
        }

        public Person getResultPerson() {
            return getResultObject(Person.FACTORY);
        }

        public UserId getUserId() {
            return getRequest().getValue("userId", UserId.FACTORY);
        }

        /**
         * @param escapeType Escape-Type Specifies the type of escaping to use
         *        on any AppData values included in the response. Defaults to
         *        "htmlEscape".
         * @return this
         */
        public Get setEscapeType(String escapeType) {
            getRequest().setValue("escapeType", escapeType);
            return this;
        }

        /**
         * @param fields Array<String> An array of Person field names. For
         *        standard values, see the Person object.
         */
        public Get setFields(String... fields) {
            getRequest().setValues("fields", fields);
            return this;
        }

        /**
         * @param groupId The Group ID of the group of users related to User ID.
         *        Defaults to "@self", which MUST return only the Person
         *        object(s) specified by the userId parameter.
         * @return this
         */
        public Get setGroupId(GroupId groupId) {
            return setGroupId(groupId.toString());
        }

        /**
         * @param groupId The Group ID of the group of users related to User ID.
         *        Defaults to "@self", which MUST return only the Person
         *        object(s) specified by the userId parameter.
         * @return this
         */
        public Get setGroupId(String groupId) {
            getRequest().setValue("groupId", groupId);
            return this;
        }

        public void setResultPeople(Collection<Person> peopleList) {
            reply(peopleList);
        }

        public void setResultPeople(List<Person> people) {
            Collection<Person> collection = new Collection<Person>(
                Person.FACTORY);
            collection.setEntries(people);
            setResultPeople(collection);
        }

        public void setResultPerson(Person person) {
            reply(person);
        }

        /**
         * User-Id User ID of person to retrieve. Defaults to "@me", which MUST
         * return the currently logged in user. Note that the userId parameter
         * is not applicable in the REST protocol, as the user is identified in
         * the REST-URI-FRAGMENT.
         * 
         * @param userId
         */
        public Get setUserId(String userId) {
            getRequest().setValue("userId", userId);
            return this;
        }

        /**
         * User-Id User ID of person to retrieve. Defaults to "@me", which MUST
         * return the currently logged in user. Note that the userId parameter
         * is not applicable in the REST protocol, as the user is identified in
         * the REST-URI-FRAGMENT.
         * 
         * @param userId
         */
        public Get setUserId(UserId userId) {
            return setUserId(userId.toString());
        }

    }

    /**
     * 
     */
    public People() {
    }

}

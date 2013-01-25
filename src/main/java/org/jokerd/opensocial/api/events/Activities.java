/**
 * 
 */
package org.jokerd.opensocial.api.events;

import java.util.List;

import org.jokerd.opensocial.api.model.Activity;
import org.jokerd.opensocial.api.model.Collection;
import org.jokerd.opensocial.api.model.GroupId;
import org.jokerd.opensocial.api.model.ObjectId;
import org.jokerd.opensocial.api.model.UserId;
import org.ubimix.commons.json.JsonValue.IJsonValueFactory;
import org.ubimix.commons.json.rpc.RpcError;

/**
 * @author kotelnikov
 */
public class Activities extends Service {

    /**
     * @author kotelnikov
     */
    public static class Get extends ServiceCall {

        private static IJsonValueFactory<Collection<Activity>> COLLECTION_FACTORY = Collection
            .getCollectionFactory(Activity.FACTORY);

        /**
         * @param activities
         * @return a list of resulting collection
         */
        public static Collection<Activity> newActivities(
            List<Activity> activities) {
            Collection<Activity> collection = new Collection<Activity>(
                Activity.FACTORY);
            collection.setEntries(activities);
            return collection;
        }

        public Get() {
            setUserId(UserId.ME);
            setGroupId(GroupId.SELF);
        }

        /**
         * Returns the response for this request as a list of activities.
         * 
         * @return a list of activities
         */
        public Collection<Activity> getActivities() {
            RpcError error = getResultError();
            if (error != null) {
                return null;
            }
            Collection<Activity> result = getResultObject(COLLECTION_FACTORY);
            return result;
        }

        /**
         * Specifies a list of individual activities to include in the response.
         * In the REST protocol, the activityIds are specified in the
         * REST-URI-Fragment, rather than in the REST-Query-Parameters.
         * Optional.
         */
        public List<ObjectId> getActivityIds() {
            return getRequest().getList("activityIds", ObjectId.FACTORY);
        }

        /**
         * Specifies that the response should only contain activities generated
         * by the given appId. If not included, the container MUST return
         * activities created by the currently authenticated app. In the REST
         * protocol, the appId is specified in the REST-URI-Fragment, rather
         * than in the REST-Query-Parameters. Optional.
         */
        public ObjectId getAppId() {
            return getRequest().getValue("appId", ObjectId.FACTORY);
        }

        /**
         * The group ID of the group of users whose activities are to be
         * returned. Defaults to "@self", which MUST return only the Activity
         * objects specified by the userId parameter. In the REST protocol, the
         * groupId is specified in the REST-URI-Fragment, rather than in the
         * REST-Query-Parameters.
         */
        public GroupId getGroupId() {
            return getRequest().getValue("groupId", GroupId.FACTORY);
        }

        /**
         * User-Id or Array<User-Id> User ID(s) of the person whose activities
         * are to be returned. Defaults to "@me", indicating the currently
         * authenticated user. In the REST protocol, userId is specified in the
         * REST-URI-Fragment, rather than in the REST-Query-Parameters.
         */
        public UserId getUserId() {
            return getRequest().getValue("userId", UserId.FACTORY);
        }

        /**
         * Sets the resulting collection of activities.
         * 
         * @param collection the collection of activities.
         * @see #newActivities(List)
         * @return this request
         */
        public Get setActivities(Collection<Activity> collection) {
            reply(collection);
            return this;
        }

        /***
         * Sets the resulting activities.
         * 
         * @return this request
         */
        public Get setActivities(List<Activity> activities) {
            Collection<Activity> collection = newActivities(activities);
            setActivities(collection);
            return this;
        }

        /**
         * Specifies a list of individual activities to include in the response.
         * In the REST protocol, the activityIds are specified in the
         * REST-URI-Fragment, rather than in the REST-Query-Parameters.
         * Optional.
         * 
         * @return this request
         */
        public Get setActivityIds(List<ObjectId> list) {
            getRequest().setValue("activityIds", list);
            return this;
        }

        /**
         * Specifies that the response should only contain activities generated
         * by the given appId. If not included, the container MUST return
         * activities created by the currently authenticated app. In the REST
         * protocol, the appId is specified in the REST-URI-Fragment, rather
         * than in the REST-Query-Parameters. Optional.
         * 
         * @return this request
         */
        public Get setAppId(ObjectId appId) {
            getRequest().setValue("appId", appId);
            return this;
        }

        /**
         * The group ID of the group of users whose activities are to be
         * returned. Defaults to "@self", which MUST return only the Activity
         * objects specified by the userId parameter. In the REST protocol, the
         * groupId is specified in the REST-URI-Fragment, rather than in the
         * REST-Query-Parameters.
         * 
         * @return this request
         */
        public Get setGroupId(GroupId groupId) {
            getRequest().setValue("groupId", groupId);
            return this;
        }

        /**
         * User-Id or Array<User-Id> User ID(s) of the person whose activities
         * are to be returned. Defaults to "@me", indicating the currently
         * authenticated user. In the REST protocol, userId is specified in the
         * REST-URI-Fragment, rather than in the REST-Query-Parameters.
         * 
         * @param userId
         * @return this request
         */
        public Get setUserId(UserId userId) {
            getRequest().setValue("userId", userId);
            return this;
        }
    }

}

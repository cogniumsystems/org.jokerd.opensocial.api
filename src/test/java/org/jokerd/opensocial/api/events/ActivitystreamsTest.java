/**
 * 
 */
package org.jokerd.opensocial.api.events;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.jokerd.opensocial.api.events.Activitystreams;
import org.jokerd.opensocial.api.events.Activitystreams.Get;
import org.jokerd.opensocial.api.model.ActivityEntry;
import org.jokerd.opensocial.api.model.ActivityObject;
import org.jokerd.opensocial.api.model.Collection;
import org.jokerd.opensocial.api.model.DomainName;
import org.jokerd.opensocial.api.model.GroupId;
import org.ubimix.commons.events.calls.CallListener;

/**
 * @author kotelnikov
 */
public class ActivitystreamsTest extends ServiceCallTest {

    /**
     * @param name
     */
    public ActivitystreamsTest(String name) {
        super(name);
    }

    protected String getMessage(String firstName, String lastName) {
        return "Hello, " + firstName + " " + lastName + "!";
    }

    public void test() throws Exception {
        DomainName domain = new DomainName("facebook.com");
        final GroupId testGroupId = new GroupId(domain, "friends");
        final ActivityEntry testActivity = new ActivityEntry();

        ActivityObject user = new ActivityObject()
            .setId("john.smith")
            .setDisplayName("John Smith");
        ActivityObject song = new ActivityObject()
            .setDisplayName("A super song");
        ActivityObject playList = new ActivityObject()
            .setDisplayName("Play List");
        // In its simplest form, an activity consists of an
        // actor, a verb, an an object, and a target
        testActivity
            .setTitle("Hello, world")
            .setActor(user)
            .setVerb("add")
            .setObject(song)
            .setTarget(playList);

        fServerEventManager.addListener(
            Activitystreams.Get.class,
            new CallListener<Activitystreams.Get>() {
                @Override
                protected void handleRequest(Activitystreams.Get event) {
                    GroupId groupId = event.getGroupId();
                    assertNotNull(groupId);
                    assertEquals(testGroupId, groupId);
                    event.setActivities(Arrays.asList(testActivity));
                }
            });

        Activitystreams.Get get = new Activitystreams.Get();
        String str = get.toString();
        System.out.println(str);
        get.setGroupId(testGroupId);

        fClientEventManager.fireEvent(
            get,
            new CallListener<Activitystreams.Get>() {
                @Override
                protected void handleResponse(Get event) {
                    Collection<ActivityEntry> activities = event
                        .getActivities();
                    assertNotNull(activities);
                    List<ActivityEntry> list = activities.getEntries();
                    assertNotNull(list);
                    assertEquals(1, list.size());
                    assertEquals(testActivity, list.get(0));
                }
            });
        Set<Throwable> errors = get.getErrors();
        assertNull(errors);
    }
}

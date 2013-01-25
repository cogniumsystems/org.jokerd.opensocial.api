/**
 * 
 */
package org.jokerd.opensocial.api.events;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.jokerd.opensocial.api.events.Activities;
import org.jokerd.opensocial.api.events.Activities.Get;
import org.jokerd.opensocial.api.model.Activity;
import org.jokerd.opensocial.api.model.Collection;
import org.jokerd.opensocial.api.model.DomainName;
import org.jokerd.opensocial.api.model.GroupId;
import org.jokerd.opensocial.api.model.UserId;
import org.ubimix.commons.events.calls.CallListener;

/**
 * @author kotelnikov
 */
public class ActivitesTest extends ServiceCallTest {

    /**
     * @param name
     */
    public ActivitesTest(String name) {
        super(name);
    }

    protected String getMessage(String firstName, String lastName) {
        return "Hello, " + firstName + " " + lastName + "!";
    }

    public void test() throws Exception {
        DomainName domain = new DomainName("bounceit.net");
        final UserId testUserId = new UserId(domain, "john.smith");
        final GroupId testGroupId = new GroupId(domain, "mysupergroup");
        final Activity testActivity = new Activity();
        testActivity.setTitle("Hello, world");
        testActivity.setUserId(testUserId);

        fServerEventManager.addListener(
            Activities.Get.class,
            new CallListener<Activities.Get>() {
                @Override
                protected void handleRequest(Activities.Get event) {
                    GroupId groupId = event.getGroupId();
                    assertNotNull(groupId);
                    assertEquals(testGroupId, groupId);
                    event.setActivities(Arrays.asList(testActivity));
                }
            });

        Activities.Get get = new Activities.Get();
        String str = get.toString();
        System.out.println(str);
        get.setGroupId(testGroupId);

        fClientEventManager.fireEvent(get, new CallListener<Activities.Get>() {
            @Override
            protected void handleResponse(Get event) {
                Collection<Activity> activities = event.getActivities();
                assertNotNull(activities);
                List<Activity> list = activities.getEntries();
                assertNotNull(list);
                assertEquals(1, list.size());
                assertEquals(testActivity, list.get(0));
            }
        });
        Set<Throwable> errors = get.getErrors();
        assertNull(errors);
    }

}

/**
 * 
 */
package org.jokerd.opensocial.api.events;

import java.util.ArrayList;
import java.util.List;

import org.jokerd.opensocial.api.events.People;
import org.jokerd.opensocial.api.events.People.Get;
import org.jokerd.opensocial.api.model.Collection;
import org.jokerd.opensocial.api.model.GroupId;
import org.jokerd.opensocial.api.model.Person;
import org.jokerd.opensocial.api.model.UserId;
import org.ubimix.commons.events.calls.CallListener;
import org.ubimix.commons.json.rpc.RpcError;

/**
 * @author kotelnikov
 */
public class PeopleServiceTest extends ServiceCallTest {

    /**
     * @param name
     */
    public PeopleServiceTest(String name) {
        super(name);
    }

    protected Person newPerson(String str) {
        return Person.FACTORY.newValue(str);
    }

    public void test() throws Exception {
        final Person person = newPerson(""
            + "{\n"
            + "  'id' : '34KJDCSKJN2HHF0DW20394',\n"
            + "  'name' : { 'unstructured' : 'Jane Doe'},\n"
            + "  'gender' : 'female'\n"
            + "}");

        final List<Person> friends = new ArrayList<Person>();
        friends.add(newPerson(""
            + "{\n"
            + "  'id' : '34KJDCSKJN2HHF0DW20394',\n"
            + "  'name' : { 'unstructured' : 'Jane Doe'},\n"
            + "  'gender' : 'female'\n"
            + "}"));
        friends.add(newPerson(""
            + "{\n"
            + "  'id' : 'VMK92BFH3DNWRYX39673DF',\n"
            + "  'name' : { 'unstructured' : 'John Smith'},\n"
            + "  'gender' : 'female'\n"
            + "}"));

        // Server side
        fServerEventManager.addListener(
            People.Get.class,
            new CallListener<People.Get>() {
                @Override
                protected void handleRequest(People.Get event) {
                    GroupId groupId = event.getGroupId();
                    UserId userId = event.getUserId();
                    if (!person.getId().equals(userId)) {
                        event.setError(new RpcError(
                            RpcError.ERROR_INVALID_PARAMS,
                            "A bad user ID"));
                    } else {
                        if (GroupId.FRIENDS.equals(groupId)) {
                            Collection<Person> result = new Collection<Person>(
                                Person.FACTORY);
                            result.setEntries(friends);
                            result.setStartIndex(1);
                            result.setItemsPerPage(2);
                            result.setTotalResults(100);
                            event.setResultPeople(result);
                        } else {
                            event.setResultPerson(person);
                        }

                    }
                }
            });

        // --------------------------------------------------------------------
        // Client side

        // Get a user profile
        People.Get get = new People.Get("34KJDCSKJN2HHF0DW20394").setFields(
            "name",
            "gender");
        {
            final Person[] response = { null };
            fClientEventManager.fireEvent(get, new CallListener<People.Get>() {
                @Override
                protected void handleResponse(Get event) {
                    response[0] = event.getResultPerson();
                }
            });
            assertFalse(get.hasErrors());
            assertNotNull(response[0]);
            assertEquals(person, response[0]);
        }

        // Get a list of friends
        {
            @SuppressWarnings("unchecked")
            final Collection<Person>[] response = toArray((Collection<Person>) null);
            get = new People.Get("34KJDCSKJN2HHF0DW20394").setFields(
                "name",
                "gender").setGroupId(GroupId.FRIENDS);
            fClientEventManager.fireEvent(get, new CallListener<People.Get>() {
                @Override
                protected void handleResponse(Get event) {
                    response[0] = event.getResultPeople();
                }
            });
            assertFalse(get.hasErrors());
            assertNotNull(response[0]);

            assertEquals(1, response[0].getStartIndex());
            assertEquals(2, response[0].getItemsPerPage());
            assertEquals(100, response[0].getTotalResults());

            List<Person> people = response[0].getEntries();
            assertNotNull(people);
            assertEquals(friends.size(), people.size());
            for (int i = 0; i < people.size(); i++) {
                assertEquals(friends.get(i), people.get(i));
            }
        }
    }

    private Collection<Person>[] toArray(Collection<Person>... array) {
        return array;
    }
}

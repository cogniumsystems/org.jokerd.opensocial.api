/**
 * 
 */
package org.jokerd.opensocial.api.events;

import junit.framework.TestCase;

import org.jokerd.opensocial.api.model.ActivityEntry;
import org.ubimix.commons.cursor.ICursor;
import org.ubimix.commons.cursor.SequentialCursor;

/**
 * @author kotelnikov
 */
public class ActivityStreamTest extends TestCase {

    /**
     * @param name
     */
    public ActivityStreamTest(String name) {
        super(name);
    }

    public void test() throws Exception {
        SequentialCursor<ActivityEntry, RuntimeException> cursor = new SequentialCursor<ActivityEntry, RuntimeException>() {
            @Override
            protected ICursor<ActivityEntry, RuntimeException> loadNextCursor(
                ICursor<ActivityEntry, RuntimeException> cursor)
                throws RuntimeException {
                return null;
            }
        };
    }

}

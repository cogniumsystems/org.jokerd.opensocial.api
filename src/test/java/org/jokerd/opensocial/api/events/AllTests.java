package org.jokerd.opensocial.api.events;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

    public static Test suite() {
        TestSuite suite = new TestSuite(AllTests.class.getName());
        //$JUnit-BEGIN$
        suite.addTestSuite(ActivitesTest.class);
        suite.addTestSuite(ActivitystreamsTest.class);
        suite.addTestSuite(ActivityStreamTest.class);
        suite.addTestSuite(PeopleServiceTest.class);
        //$JUnit-END$
        return suite;
    }

}

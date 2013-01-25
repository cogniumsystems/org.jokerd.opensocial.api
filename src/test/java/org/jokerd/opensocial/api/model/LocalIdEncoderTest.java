/**
 * 
 */
package org.jokerd.opensocial.api.model;

import org.jokerd.opensocial.api.model.LocalIdEncoder;

import junit.framework.TestCase;

/**
 * @author kotelnikov
 */
public class LocalIdEncoderTest extends TestCase {

    /**
     * @param name
     */
    public LocalIdEncoderTest(String name) {
        super(name);
    }

    public void test() throws Exception {
        test("");
        test("abc");
        test("\"'-é:");
        test("123abc");
        test("мама мыла раму");
        test("http://opensocial-resources.googlecode.com/svn/spec/trunk/Core-Data.xml#Local-Id");
    }

    private void test(String str) {
        LocalIdEncoder encoder = new LocalIdEncoder();
        String encoded = encoder.encode(str);
        String test = encoder.decode(encoded);
        assertEquals(str, test);
    }

}

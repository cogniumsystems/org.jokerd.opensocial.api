/**
 * 
 */
package org.jokerd.opensocial.api.model;

/**
 * An ActionLink encompasses an action that a user may perform against an
 * actionable resource. It defines a caption for the action to perform, a URL to
 * identify the target actionable resource, and the HTTP operation to invoke the
 * resource with. For example, an "Add Friend" button has a caption (namely,
 * "Add Friend") and references the resource that will be invoked when the
 * button is clicked.
 * 
 * @author kotelnikov
 */
// http://opensocial-resources.googlecode.com/svn/spec/2.0.1/Social-Data.xml#ActionLink
public class ActionLink extends DataObject {

    public static IJsonValueFactory<ActionLink> FACTORY = new IJsonValueFactory<ActionLink>() {
        public ActionLink newValue(Object object) {
            return new ActionLink().setJsonObject(object);
        }
    };

    /**
     * 
     */
    public ActionLink() {
    }

    /**
     * @param object
     */
    public ActionLink(Object object) {
        super(object);
    }

    /**
     * Represents a hint that MAY be used by the presentation layer to allow
     * interaction with the user, e.g. a button that invokes an POST.
     */
    public String getCaption() {
        return getString("caption");
    }

    /**
     * Identifies the HTTP operation to perform against the actionable resource.
     * Should be one of "GET", "PUT", "POST", "DELETE", or other standard HTTP
     * verb. The HTTP verb is optional, and if omitted defaults to "GET".
     */
    public String getHttpVerb() {
        return getString("httpVerb");
    }

    /**
     * URL which represents the target web hook endpoint that can be invoked
     * using the specified HTTP verb.
     */
    public String getTarget() {
        return getString("target");
    }

    /**
     * Represents a hint that MAY be used by the presentation layer to allow
     * interaction with the user, e.g. a button that invokes an POST.
     */
    public ActionLink setCaption(String caption) {
        setValue("caption", caption);
        return this;
    }

    /**
     * Identifies the HTTP operation to perform against the actionable resource.
     * Should be one of "GET", "PUT", "POST", "DELETE", or other standard HTTP
     * verb. The HTTP verb is optional, and if omitted defaults to "GET".
     */
    public ActionLink setHttpVerb(String value) {
        setValue("httpVerb", value);
        return this;
    }

    /**
     * URL which represents the target web hook endpoint that can be invoked
     * using the specified HTTP verb.
     */
    public ActionLink setTarget(String value) {
        setValue("target", value);
        return this;
    }
}

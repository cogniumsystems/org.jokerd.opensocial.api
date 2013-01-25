/**
 * 
 */
package org.jokerd.opensocial.api.events;

import org.ubimix.commons.json.rpc.RpcRequest;
import org.ubimix.commons.rpc.RpcCall;

/**
 * @author kotelnikov
 */
public class Service {

    /**
     * @author kotelnikov
     */
    public static abstract class ServiceCall extends RpcCall {

        public ServiceCall() {
            super(new RpcRequest());
        }

    }

    protected static String getRpcName(Class<?> cls) {
        String methodName = cls.getName();
        int idx = methodName.lastIndexOf('.');
        if (idx > 0) {
            methodName = methodName.substring(idx + 1);
        }
        StringBuilder buf = new StringBuilder();
        String[] array = methodName.split("[$]");
        for (String segment : array) {
            if (buf.length() > 0) {
                buf.append('.');
            }
            if (segment.length() > 0) {
                buf.append(Character.toLowerCase(segment.charAt(0)));
                buf.append(segment.substring(1));
            }
        }
        methodName = buf.toString();
        return methodName;
    }

    /**
     * 
     */
    public Service() {
    }

    @Override
    public String toString() {
        Class<? extends Service> cls = getClass();
        return getRpcName(cls);
    }

}

package org.jokerd.opensocial.api.events;

import junit.framework.TestCase;

import org.ubimix.commons.events.IEventManager;
import org.ubimix.commons.rpc.RpcCallTestUtil;

/**
 * @author kotelnikov
 */
public abstract class ServiceCallTest extends TestCase {

    protected IEventManager fClientEventManager;

    protected IEventManager fServerEventManager;

    public ServiceCallTest(String name) {
        super(name);
    }

    @Override
    protected void setUp() throws Exception {
        RpcCallTestUtil util = new RpcCallTestUtil();
        fServerEventManager = util.getServerEventManager();
        fClientEventManager = util.getClientEventManager();
    }
}
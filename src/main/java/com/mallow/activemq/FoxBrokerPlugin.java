package com.mallow.activemq;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerPlugin;

/**
 * Created by lcy on 2016/4/26.
 */
public class FoxBrokerPlugin implements BrokerPlugin {
    public Broker installPlugin(Broker broker) throws Exception {
        return new FoxBroker(broker);
    }
}

package com.mallow.activemq;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerPlugin;

/**
 * Created by lcy on 2016/4/26.
 * A plugin can be useful in test enviroment, which will discard all messages when there are more than 1000 messages pending
 */
public class LimitQueueSizePlugin implements BrokerPlugin {
    public Broker installPlugin(Broker broker) throws Exception {
        return new LimitQueueSIzeBroker(broker);
    }
}

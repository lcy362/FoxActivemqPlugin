package com.mallow.activemq;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerFilter;
import org.apache.activemq.broker.ConsumerBrokerExchange;
import org.apache.activemq.broker.ProducerBrokerExchange;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.Message;
import org.apache.activemq.command.MessageAck;
import org.apache.activemq.command.MessageDispatch;
import org.apache.log4j.Logger;

import java.util.Queue;

/**
 * Created by lcy on 2016/4/26.
 */
public class LimitQueueSIzeBroker extends BrokerFilter {
    Logger logger = Logger.getLogger("test");
    public LimitQueueSIzeBroker(Broker next) {
        super(next);
    }

    @Override
    public void send(ProducerBrokerExchange producerExchange, Message messageSend) throws Exception {
        int nowsize = 0;
        ActiveMQDestination destination = messageSend.getDestination();
        System.out.println(destination);
        super.send(producerExchange, messageSend);
    }

}

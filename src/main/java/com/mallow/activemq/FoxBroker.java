package com.mallow.activemq;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerFilter;
import org.apache.activemq.broker.ConsumerBrokerExchange;
import org.apache.activemq.broker.ProducerBrokerExchange;
import org.apache.activemq.command.Message;
import org.apache.activemq.command.MessageAck;
import org.apache.activemq.command.MessageDispatch;
import org.apache.log4j.Logger;

/**
 * Created by lcy on 2016/4/26.
 */
public class FoxBroker extends BrokerFilter {
    Logger logger = Logger.getLogger("test");
    public FoxBroker(Broker next) {
        super(next);
    }

    @Override
    public void send(ProducerBrokerExchange producerExchange, Message messageSend) throws Exception {
        try {
            String ip = producerExchange.getConnectionContext().getConnection().getRemoteAddress();
            String destinationName = messageSend.getDestination().getPhysicalName();
            logger.info("send_" + destinationName + " "  + ip);
        } catch (Exception e) {
            logger.error("activemq send log error: " + e, e);
        }
        super.send(producerExchange, messageSend);
    }

    @Override
    public void postProcessDispatch(MessageDispatch messageDispatch) {
        try {
            String destinationName = messageDispatch.getDestination().getPhysicalName();
            String consumerId = messageDispatch.getConsumerId().getConnectionId();
            logger.info("dispatch_" + destinationName + " " + consumerId);
        } catch (Exception e) {
            logger.error("activemq dispatch log error: " + e, e);
        }
        super.postProcessDispatch(messageDispatch);
    }

    @Override
    public void acknowledge(ConsumerBrokerExchange consumerExchange, MessageAck ack) throws Exception {
        try {
            String ip = consumerExchange.getConnectionContext().getConnection().getRemoteAddress();
            String destinationName = ack.getDestination().getPhysicalName();
            logger.info("ack_" + destinationName + " " + ip);
        } catch (Exception e) {
            logger.error("activemq consume log error: " + e, e);

        }
        super.acknowledge(consumerExchange, ack);
    }
}

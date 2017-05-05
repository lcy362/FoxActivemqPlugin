package com.mallow.activemq;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerFilter;
import org.apache.activemq.broker.ProducerBrokerExchange;
import org.apache.activemq.broker.region.Destination;
import org.apache.activemq.broker.region.DestinationStatistics;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.Message;
import org.apache.log4j.Logger;

import java.util.Set;


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
        ActiveMQDestination msgDest = messageSend.getDestination();
        String physicalName = msgDest.getPhysicalName();
        logger.info("dest: " + physicalName);

        ActiveMQDestination queryDestination = ActiveMQDestination.createDestination(physicalName, msgDest.getDestinationType());
        Set<Destination> destinations = getDestinations(queryDestination);
        logger.info(destinations);
        long count = 0;
        for (Destination dest : destinations) {
            DestinationStatistics stats = dest.getDestinationStatistics();
            if (stats != null) {
                count = stats.getMessageSize().getCount();
                logger.info("size: " + count);
            }
        }
        if (count < 1000) {
            super.send(producerExchange, messageSend);
        } else {
            logger.info("discard message");
        }
    }

}

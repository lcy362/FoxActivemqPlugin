# FoxActivemqPlugin

a very simple example of developing activemq plugins.

## Plugins
### testPlugin
com.mallow.activemq.FoxBrokerPlugin

just for show, log something when messages sended or produced.

### LimitQueueSizePlugin
com.mallow.activemq.LimitQueueSizePlugin

A plugin can be useful in test enviroment, which will discard all messages when there are more than 1000 messages pending.

## USAGE
1. put the FoxActivemqPlugin jar into activemq's lib folder.
2. add this config to activemq.xml:
```xml
<plugins>
    <bean xmlns="http://www.springframework.org/schema/beans" id="testPlugin"  class="com.mallow.activemq.FoxBrokerPlugin"/>
    <bean xmlns="http://www.springframework.org/schema/beans" id="purgePlugin" class="com.mallow.activemq.LimitQueueSizePlugin"/>
</plugins>
```
for more detail, see
http://activemq.apache.org/developing-plugins.html

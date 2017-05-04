# FoxActivemqPlugin

a very simple example of developing activemq plugins.

## USAGE
1. put the FoxActivemqPlugin jar into activemq's lib folder.
2. add this config to activemq.xml:
```xml
		<plugins>
			<bean xmlns="http://www.springframework.org/schema/beans" id="testPlugin"  class="com.mallow.activemq.FoxBrokerPlugin"/>
		</plugins>
```
for more detail, see
http://activemq.apache.org/developing-plugins.html

package com.szkingdom.ssm.logging;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.log4j.spi.LoggingEvent;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by tianf on 2016/8/2.
 */
public class LogMessageListener implements MessageListener {

    public void onMessage(Message message) {
        try {
            // receive log event in your consumer
            LoggingEvent event = (LoggingEvent)((ActiveMQObjectMessage)message).getObject();
            System.out.println("Logging project: [" + event.getLevel() + "]: "+ event.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

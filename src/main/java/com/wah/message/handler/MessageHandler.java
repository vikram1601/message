package com.wah.message.handler;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.suj1th.rabpubsub.AbstractSubscriber;
import com.suj1th.rabpubsub.EventType;
import com.wah.message.bean.MessagePayload;
import com.wah.message.service.MessageDataBuilder;
import com.wah.message.service.MessageSender;

/**
 *
 * @author vikram
 *
 */
@Component
public class MessageHandler extends AbstractSubscriber<MessagePayload> {
    private MessageDataBuilder messageDataBuilder;
    private MessageSender messageSender;
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * @return the messageSender
     */
    public MessageSender getEmailSender() {
        return this.messageSender;
    }


    /**
     * @param messageSender the messageSender to set
     */
    @Autowired
    public void setEmailSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    /**
     *
     */
    public MessageHandler() {}


    @Override
    protected void handle(MessagePayload payload) {
        this._sendEmail(payload);
    }


    private boolean _sendEmail(MessagePayload payload) {
        boolean flag = false;
        try {
            payload = this.messageDataBuilder.buildMessageData(payload);
            flag = this.messageSender.sendMessage(payload);
        } catch (Exception e) {
            this.logger.error("Exception", e);
        }
        return flag;
    }

    @Override
    protected EventType getEventType() {
        return EventType.TEST;
    }


    /**
     * @return the messageDataBuilder
     */
    public MessageDataBuilder getMessageDataBuilder() {
        return this.messageDataBuilder;
    }


    /**
     * @param messageDataBuilder the messageDataBuilder to set
     */
    public void setMessageDataBuilder(MessageDataBuilder messageDataBuilder) {
        this.messageDataBuilder = messageDataBuilder;
    }


}
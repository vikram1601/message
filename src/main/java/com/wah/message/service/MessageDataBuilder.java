package com.wah.message.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wah.message.bean.MessagePayload;
import com.wah.message.constants.EventType;

/**
 *
 * @author vikram
 *
 */
@Service("emailDataBuilder")
public class MessageDataBuilder {
    private final Logger logger = Logger.getLogger(this.getClass());


    /**
     * @author vikram
     * @param payload
     * @return {@link MessagePayload}
     */
    public MessagePayload buildMessageData(MessagePayload payload) {
        String messageTemplate = "";;
        if (payload.getEventType() == EventType.USER_SIGNUP) {
            messageTemplate = "signupmailer";
        }

        payload.setContent(messageTemplate);
        return payload;
    }

}

package com.wah.message.service;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wah.message.bean.MessagePayload;

/**
 * @author vikram
 */
@Service("messageSender")
public class MessageSender {

    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     *
     */
    public MessageSender() {}

    /**
     *
     */
    @PostConstruct
    public void init() {
        // configuration loading
    }


    /**
     * this is used to send messages
     *
     * @author vikram
     * @param payload
     * @throws Exception
     * @return boolean
     */
    public boolean sendMessage(MessagePayload payload) throws Exception {

        return true;
    }



}

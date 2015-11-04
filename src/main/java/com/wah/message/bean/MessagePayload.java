package com.wah.message.bean;

import java.util.HashSet;
import java.util.Set;

import com.suj1th.rabpubsub.Payload;
import com.wah.message.constants.EventType;
/**
 *
 * @author vikram
 *
 */
public class MessagePayload extends Payload {
    private Set<String> to = new HashSet<String>();
    private String content;
    private EventType eventType;

    /**
     * @return the to
     */
    public Set<String> getTo() {
        return this.to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(Set<String> to) {
        this.to = to;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return this.content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the eventType
     */
    public EventType getEventType() {
        return this.eventType;
    }

    /**
     * @param eventType the eventType to set
     */
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }


}

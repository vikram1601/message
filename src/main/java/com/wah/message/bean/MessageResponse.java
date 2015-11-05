package com.wah.message.bean;

/**
 *
 * @author vikram
 *
 */
public class MessageResponse {

    private String APIStatus;
    private String SessionId;
    private String Payload;

    /**
     * @return the aPIStatus
     */
    public String getAPIStatus() {
        return this.APIStatus;
    }

    /**
     * @param aPIStatus the aPIStatus to set
     */
    public void setAPIStatus(String aPIStatus) {
        this.APIStatus = aPIStatus;
    }

    /**
     * @return the sessionId
     */
    public String getSessionId() {
        return this.SessionId;
    }

    /**
     * @param sessionId the sessionId to set
     */
    public void setSessionId(String sessionId) {
        this.SessionId = sessionId;
    }

    /**
     * @return the payload
     */
    public String getPayload() {
        return this.Payload;
    }

    /**
     * @param payload the payload to set
     */
    public void setPayload(String payload) {
        this.Payload = payload;
    }

}

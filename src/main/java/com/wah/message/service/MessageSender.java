package com.wah.message.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wah.message.bean.MessagePayload;
import com.wah.message.config.MessageConfig;

/**
 * @author vikram
 */
@Service("messageSender")
public class MessageSender {
    private MessageConfig messageConfig;
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
        StringBuilder url = new StringBuilder();
        url.append(this.messageConfig.smsUrl + "/");
        for (String phoneNumber : payload.getTo()) {
            url.append(phoneNumber + ",");
        }
        if (this.logger.isInfoEnabled()) {
            this.logger.info("SMS FINAL URL:" + url);
        }
        StringBuffer response = new StringBuffer("");
        try {
            URL obj = new URL(url.toString());
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // add reuqest header
            con.setRequestMethod("POST");
            // con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            // String urlParameters =
            // "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes("Msg=" + payload.getContent());
            wr.flush();
            wr.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            this.logger.error("Exception ", e);
        }
        if (this.logger.isInfoEnabled()) {
            this.logger.info("response for " + payload.getTo() + " - " + response);
        }

        return true;
    }

    /**
     * @return the messageConfig
     */
    public MessageConfig getMessageConfig() {
        return this.messageConfig;
    }

    /**
     * @param messageConfig the messageConfig to set
     */
    @Autowired
    public void setMessageConfig(MessageConfig messageConfig) {
        this.messageConfig = messageConfig;
    }



}

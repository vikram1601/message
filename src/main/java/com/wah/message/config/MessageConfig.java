package com.wah.message.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.config.PropertySetterException;
import org.springframework.stereotype.Component;

/**
 *
 * @author vikram
 *
 */
@Component
public class MessageConfig {

    private final String defaultConfig = "/com/wah/message/config/messageConfig.properties";

    /**
     *
     */
    public final String MSG_SEND_MAIL_SUCCESS;
    /**
     *
     */
    public final String MSG_SEND_MAIL_FAILURE;

    /**
     *
     */
    public final String smsText;
    /**
     *
     */
    public final String smsUrl;


    private Properties config = new Properties();


    /**
     * @author vikram
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws PropertySetterException
     */
    public MessageConfig() throws ClassNotFoundException, IOException, PropertySetterException {
        Class<?> configClass = Class.forName("com.wah.message.config.MessageConfig");
        InputStream is = configClass.getResourceAsStream(this.defaultConfig);
        this.config.load(is);

        if (is != null) {
            this.config.load(is);
        }

        this.MSG_SEND_MAIL_SUCCESS = this.config.getProperty("MSG_SEND_MAIL_SUCCESS");
        this.MSG_SEND_MAIL_FAILURE = this.config.getProperty("MSG_SEND_MAIL_FAILURE");

        if (this.MSG_SEND_MAIL_SUCCESS == null) {
            throw new PropertySetterException("MSG_SEND_MAIL_SUCCESS cannot be undefined");
        }

        if (this.MSG_SEND_MAIL_FAILURE == null) {
            throw new PropertySetterException("MSG_SEND_MAIL_FAILURE cannot be undefined");
        }
        this.smsText = this.config.getProperty("smsText");
        this.smsUrl = this.config.getProperty("smsUrl");
    }


    /**
     * @return the config
     */
    public Properties getConfig() {
        return this.config;
    }


    /**
     * @param config the config to set
     */
    public void setConfig(Properties config) {
        this.config = config;
    }


    /**
     * @return the defaultConfig
     */
    public String getDefaultConfig() {
        return this.defaultConfig;
    }


    /**
     * @return the mSG_SEND_MAIL_SUCCESS
     */
    public String getMSG_SEND_MAIL_SUCCESS() {
        return this.MSG_SEND_MAIL_SUCCESS;
    }


    /**
     * @return the mSG_SEND_MAIL_FAILURE
     */
    public String getMSG_SEND_MAIL_FAILURE() {
        return this.MSG_SEND_MAIL_FAILURE;
    }


    /**
     * @return smsText
     */
    public String getSmsText() {
        return this.smsText;
    }

    /**
     * @return smsUrl
     */
    public String getSmsUrl() {
        return this.smsUrl;
    }

}

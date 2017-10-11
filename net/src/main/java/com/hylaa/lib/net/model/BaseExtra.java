package com.hylaa.lib.net.model;

import java.io.Serializable;

/**
 * BaseExtra.
 *
 * @author William Lee
 * @version v1.0.0
 * @created 2016-11-30.
 * @tel 152-5320-8570
 */
public class BaseExtra implements Serializable {


    /**
     * app_id : d670c174cd584a91accace43d0265427
     * app_version : 1
     * device_id : zhangsan
     * device_type : Android
     * lang : en
     * time_zone : Asia/Shanghai
     */

    private String app_id;
    private int app_version;
    private String device_id;
    private String device_type;
    private String lang;
    private String time_zone;

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public int getApp_version() {
        return app_version;
    }

    public void setApp_version(int app_version) {
        this.app_version = app_version;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }
}
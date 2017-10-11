package com.hylaa.lib.net.model;


import com.hylaa.lib.net.error.NetError;

import java.io.Serializable;

/**
 * BaseJson.
 *
 * @author William Lee
 * @version v1.0.0
 * @created 2016-11-30.
 * @tel 152-5320-8570
 */
public class BaseJson implements Serializable {

    private int code;

    private String message = "";

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NetError getError() {
        NetError ne = new NetError(code,message);
        return ne;
    }
}

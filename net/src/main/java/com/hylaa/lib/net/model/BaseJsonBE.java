package com.hylaa.lib.net.model;


import java.io.Serializable;

/**
 * BaseJson.
 *
 * @author William Lee
 * @version v1.0.0
 * @created 2016-11-30.
 * @tel 152-5320-8570
 */
public class BaseJsonBE<B, E> extends BaseJson implements Serializable {

    private B body;

    private E extra;

    public B getBody() {
        return body;
    }

    public void setBody(B body) {
        this.body = body;
    }

    public E getExtra() {
        return extra;
    }

    public void setExtra(E extra) {
        this.extra = extra;
    }

}

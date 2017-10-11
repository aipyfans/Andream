package com.hylaa.lib.net.model;

import java.io.Serializable;

/**
 * BaseWrapper.
 *
 * @author William Lee
 * @version v1.0.0
 * @created 2016-11-30.
 * @tel 152-5320-8570
 */
public class BodyWrapper<B, S, E> implements Serializable {

    private B body;

    private S secure;

    private E extra;

    public BodyWrapper() {
    }

    public BodyWrapper(B body) {
        this.body = body;
    }

    public BodyWrapper(B body, S secure) {
        this.body = body;
        this.secure = secure;
    }

    public BodyWrapper(B body, S secure, E extra) {
        this.body = body;
        this.secure = secure;
        this.extra = extra;
    }

    public B getBody() {
        return body;
    }

    public void setBody(B body) {
        this.body = body;
    }

    public S getSecure() {
        return secure;
    }

    public void setSecure(S secure) {
        this.secure = secure;
    }

    public E getExtra() {
        return extra;
    }

    public void setExtra(E extra) {
        this.extra = extra;
    }
}



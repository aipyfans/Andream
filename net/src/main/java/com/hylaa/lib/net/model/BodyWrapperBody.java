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
public class BodyWrapperBody<B> implements Serializable {

    private B body;

    public B getBody() {
        return body;
    }

    public void setBody(B body) {
        this.body = body;
    }

}



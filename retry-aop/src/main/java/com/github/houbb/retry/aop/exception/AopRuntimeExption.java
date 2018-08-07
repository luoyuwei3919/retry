/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.aop.exception;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午11:26  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class AopRuntimeExption extends RuntimeException {

    private static final long serialVersionUID = -7628954536205105689L;

    public AopRuntimeExption() {
    }

    public AopRuntimeExption(String message) {
        super(message);
    }

    public AopRuntimeExption(String message, Throwable cause) {
        super(message, cause);
    }

    public AopRuntimeExption(Throwable cause) {
        super(cause);
    }

    public AopRuntimeExption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

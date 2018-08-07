/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.guava;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/8 上午1:53  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class MyCallable implements Callable<Boolean> {

    private static final Logger LOGGER = LogManager.getLogger(HelloDemo.class);

    @Override
    public Boolean call() throws Exception {
        Callable<Boolean> callable = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                // do something useful here
                LOGGER.info("call...");
                throw new RuntimeException();
            }
        };
        return true;
    }
}

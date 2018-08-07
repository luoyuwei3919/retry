/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.spring.commonway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * <p> 远程服务 </p>
 *
 * <pre> Created: 2018/6/23 上午11:15  </pre>
 * <pre> Project: spring-boot  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class SimpleDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleDemo.class);

    public static void main(String[] args) throws Exception {
        RetryTemplate template = new RetryTemplate();

        // 策略
        SimpleRetryPolicy policy = new SimpleRetryPolicy();
        policy.setMaxAttempts(2);
        template.setRetryPolicy(policy);

        String result = template.execute(
                new RetryCallback<String, Exception>() {
                    @Override
                    public String doWithRetry(RetryContext arg0) {
                        throw new NullPointerException();
                    }
                }
                ,
                new RecoveryCallback<String>() {
                    @Override
                    public String recover(RetryContext context) {
                        return "recovery callback";
                    }
                }
        );

        LOGGER.info("result: {}", result);
    }

}

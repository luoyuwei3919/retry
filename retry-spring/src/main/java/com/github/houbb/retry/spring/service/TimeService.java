/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.spring.service;


import com.github.houbb.retry.spring.model.CbTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * <p> 重试次数的服务 </p>
 *
 * <pre> Created: 2018/6/23 上午11:15  </pre>
 * <pre> Project: spring-boot  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@Service
public class TimeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeService.class);

    /**
     * 调用方法
     */
    @Retryable(value = RuntimeException.class,
               maxAttempts = 5,
               backoff = @Backoff(delay = 2000L, multiplier = 1.5))
    public void call(CbTime cbTime) {
        LOGGER.info("Call " + cbTime);
        cbTime.setTime(cbTime.getTime() + 1);
        throw new RuntimeException();
    }

    /**
     * 补偿机制
     *
     * @param e 异常
     */
    @Recover
    public void recover(RuntimeException e, CbTime cbTime) {
        LOGGER.info("开始处理回复工作: " + cbTime);
        LOGGER.warn("We meet ex: ", e);
    }

}

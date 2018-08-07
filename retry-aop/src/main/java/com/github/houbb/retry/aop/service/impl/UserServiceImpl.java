/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.aop.service.impl;

import com.github.houbb.retry.aop.annotation.Retryable;
import com.github.houbb.retry.aop.exception.AopRuntimeExption;
import com.github.houbb.retry.aop.service.MyUserService;
import com.github.houbb.retry.common.condition.QueryUserCondition;
import com.github.houbb.retry.common.model.User;
import com.github.houbb.retry.common.service.OutService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午9:33  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@Service
public class UserServiceImpl implements MyUserService {

    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    private final OutService outService;

    @Autowired
    public UserServiceImpl(OutService outService) {
        this.outService = outService;
    }

    @Override
    @Retryable
    public User queryUser(QueryUserCondition condition) {
        outService.remoteCall();
        return new User();
    }

    @Override
    @Retryable(maxAttempts = 2)
    public void twoTimes() {
        outService.remoteCall();
    }


    @Override
    @Retryable
    public void exceptionClass() {
        LOGGER.info("exceptionClass called!");
        throw new AopRuntimeExption();
    }

    @Override
    @Retryable(maxAttempts = 5, value = AopRuntimeExption.class)
    public void fiveTimes() {
        LOGGER.info("fiveTimes called!");
        throw new AopRuntimeExption();
    }


}

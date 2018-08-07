/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.proxy.proxy;

import com.github.houbb.retry.common.condition.QueryUserCondition;
import com.github.houbb.retry.common.model.User;
import com.github.houbb.retry.proxy.common.UserServiceRetryImpl;
import com.github.houbb.retry.proxy.common.UserServiceRetryImplTest;
import com.github.houbb.retry.proxy.service.impl.UserServiceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
* UserServiceImpl Tester.
*
* @author houbinbin
* @since 08/07/2018
* @version 1.0
*/
public class UserServiceProxyImplTest {

    private static final Logger LOGGER = LogManager.getLogger(UserServiceRetryImplTest.class);

    /**
    *
    * Method: queryUser(QueryUserCondition condition)
    *
    */
    @Test
    public void queryUserTest() throws Exception {
        QueryUserCondition queryUserCondition = new QueryUserCondition();
        User user = new UserServiceRetryImpl().queryUser(queryUserCondition);
        LOGGER.info("queryUserTest：" + user);
    }

    
}

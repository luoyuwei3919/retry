/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.proxy.common;

import com.github.houbb.retry.common.condition.QueryUserCondition;
import com.github.houbb.retry.common.model.User;
import com.github.houbb.retry.proxy.proxy.UserServiceProxyImpl;
import com.github.houbb.retry.proxy.proxy.UserServiceProxyImplTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午9:21  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class UserServiceRetryImplTest {

    private static final Logger LOGGER = LogManager.getLogger(UserServiceProxyImplTest.class);

    /**
     *
     * Method: queryUser(QueryUserCondition condition)
     *
     */
    @Test
    public void queryUserTest() throws Exception {
        QueryUserCondition queryUserCondition = new QueryUserCondition();
        User user = new UserServiceProxyImpl().queryUser(queryUserCondition);
        LOGGER.info("queryUserTest：" + user);
    }

}

/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.dynamic.proxy.cglib;

import com.github.houbb.retry.common.condition.QueryUserCondition;
import com.github.houbb.retry.common.model.User;
import com.github.houbb.retry.common.service.UserService;
import com.github.houbb.retry.common.service.impl.AlwaysSuccessOutServiceImpl;
import com.github.houbb.retry.common.service.impl.RandomOutServiceImpl;
import com.github.houbb.retry.dynamic.proxy.proxy.DynamicProxy;
import com.github.houbb.retry.dynamic.proxy.proxy.DynamicProxyTest;
import com.github.houbb.retry.dynamic.proxy.service.RoleService;
import com.github.houbb.retry.dynamic.proxy.service.impl.ResourceServiceImpl;
import com.github.houbb.retry.dynamic.proxy.service.impl.RoleServiceImpl;
import com.github.houbb.retry.dynamic.proxy.service.impl.UserServiceImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午10:36  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class CglibProxyTest  {

    private static final Logger LOGGER = LogManager.getLogger(CglibProxyTest.class);

    @Test
    public void failUserServiceTest() {
        UserService proxyService = (UserService) new CglibProxy().getProxy(UserServiceImpl.class);

        User user = proxyService.queryUser(new QueryUserCondition());
        LOGGER.info("failUserServiceTest: " + user);
    }

    @Test
    public void resourceServiceTest() {
        ResourceServiceImpl proxyService = (ResourceServiceImpl) new CglibProxy().getProxy(ResourceServiceImpl.class);
        boolean result = proxyService.checkResource(new User());
        LOGGER.info("resourceServiceTest: " + result);
    }

}

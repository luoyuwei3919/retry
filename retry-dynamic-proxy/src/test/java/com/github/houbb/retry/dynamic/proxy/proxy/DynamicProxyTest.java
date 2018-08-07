/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.dynamic.proxy.proxy;

import com.github.houbb.retry.common.condition.QueryUserCondition;
import com.github.houbb.retry.common.model.User;
import com.github.houbb.retry.common.service.UserService;
import com.github.houbb.retry.common.service.impl.AlwaysSuccessOutServiceImpl;
import com.github.houbb.retry.common.service.impl.RandomOutServiceImpl;
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
 * <pre> Created: 2018/8/7 下午10:21  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class DynamicProxyTest {

    private static final Logger LOGGER = LogManager.getLogger(DynamicProxyTest.class);

    @Test
    public void failUserServiceTest() {
        UserService realService = new UserServiceImpl();
        UserService proxyService = (UserService) DynamicProxy.getProxy(realService);

        User user = proxyService.queryUser(new QueryUserCondition());
        LOGGER.info("failUserServiceTest: " + user);
    }

    @Test
    public void successUserServiceTest() {
        UserService realService = new UserServiceImpl(new AlwaysSuccessOutServiceImpl());
        UserService proxyService = (UserService) DynamicProxy.getProxy(realService);

        User user = proxyService.queryUser(new QueryUserCondition());
        LOGGER.info("successUserServiceTest: " + user);
    }

    @Test
    public void randomUserServiceTest() {
        UserService realService = new UserServiceImpl(new RandomOutServiceImpl(50));
        UserService proxyService = (UserService) DynamicProxy.getProxy(realService);

        User user = proxyService.queryUser(new QueryUserCondition());
        LOGGER.info("randomUserServiceTest: " + user);
    }

    @Test
    public void roleServiceTest() {
        RoleService realService = new RoleServiceImpl();
        RoleService proxyService = (RoleService) DynamicProxy.getProxy(realService);

        boolean hasPrivilege = proxyService.hasPrivilege(new User());
        LOGGER.info("roleServiceTest: " + hasPrivilege);
    }

    @Test
    public void resourceServiceTest() {
        ResourceServiceImpl realService = new ResourceServiceImpl();
        ResourceServiceImpl proxyService = (ResourceServiceImpl) DynamicProxy.getProxy(realService);
        proxyService.checkResource(new User());
        //TODO: 执行时直接报错
    }

}

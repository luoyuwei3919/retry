package com.github.houbb.retry.aop.service.impl;

import com.github.houbb.retry.aop.config.SpringConfig;
import com.github.houbb.retry.aop.service.MyUserService;
import com.github.houbb.retry.common.condition.QueryUserCondition;
import com.github.houbb.retry.common.model.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * UserServiceImpl Tester.
 *
 * @author houbinbin
 * @version 1.0
 * @since 08/07/2018
 */
@ContextConfiguration(classes = SpringConfig.class)
@SpringJUnitConfig
public class UserServiceImplTest {

    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private MyUserService myUserService;

    /**
     * Method: queryUser(QueryUserCondition condition)
     */
    @Test
    public void queryUserTest() throws Exception {
        User user = myUserService.queryUser(new QueryUserCondition());
        LOGGER.info("queryUserTest: " + user);
    }

    /**
     * Method: twoTimes()
     */
    @Test
    public void twoTimesTest() throws Exception {
        myUserService.twoTimes();
    }

    /**
     * Method: exceptionClass()
     */
    @Test
    public void exceptionClassTest() throws Exception {
        myUserService.exceptionClass();
    }

    /**
     * Method: fiveTimes()
     */
    @Test
    public void fiveTimesTest() throws Exception {
        myUserService.fiveTimes();
    }


}

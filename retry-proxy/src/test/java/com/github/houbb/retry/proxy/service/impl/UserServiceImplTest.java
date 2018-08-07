package com.github.houbb.retry.proxy.service.impl;

import com.github.houbb.retry.common.condition.QueryUserCondition;
import com.github.houbb.retry.common.model.User;
import com.github.houbb.retry.common.service.OutService;
import com.github.houbb.retry.common.service.impl.AlwaysSuccessOutServiceImpl;

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
public class UserServiceImplTest {

    private static final Logger LOGGER = LogManager.getLogger(UserServiceImplTest.class);

    /**
    *
    * Method: queryUser(QueryUserCondition condition)
    *
    */
    @Test
    public void failQueryUserTest() throws Exception {
        QueryUserCondition queryUserCondition = new QueryUserCondition();
        User user = new UserServiceImpl().queryUser(queryUserCondition);
        LOGGER.info("queryUserTest：" + user);
    }

    /**
     *
     * Method: queryUser(QueryUserCondition condition)
     *
     */
    @Test
    public void successQueryUserTest() throws Exception {
        QueryUserCondition queryUserCondition = new QueryUserCondition();
        OutService outService = new AlwaysSuccessOutServiceImpl();
        User user = new UserServiceImpl(outService).queryUser(queryUserCondition);
        LOGGER.info("queryUserTest：" + user);
    }

    
}

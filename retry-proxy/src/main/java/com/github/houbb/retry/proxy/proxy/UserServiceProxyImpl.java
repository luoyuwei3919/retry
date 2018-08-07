/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.proxy.proxy;

import com.github.houbb.retry.common.condition.QueryUserCondition;
import com.github.houbb.retry.common.constant.RetryConstant;
import com.github.houbb.retry.common.model.User;
import com.github.houbb.retry.common.service.UserService;
import com.github.houbb.retry.proxy.service.impl.UserServiceImpl;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午7:44  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class UserServiceProxyImpl implements UserService {

    private UserService userService = new UserServiceImpl();

    @Override
    public User queryUser(QueryUserCondition condition) {
        int times = 0;

        while (times < RetryConstant.MAX_TIMES) {
            try {
                return userService.queryUser(condition);
            } catch (Exception e) {
                times++;

                if(times >= RetryConstant.MAX_TIMES) {
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

}

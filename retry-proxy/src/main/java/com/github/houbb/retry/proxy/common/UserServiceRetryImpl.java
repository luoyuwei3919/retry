/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.proxy.common;

import com.github.houbb.retry.common.condition.QueryUserCondition;
import com.github.houbb.retry.common.constant.RetryConstant;
import com.github.houbb.retry.common.model.User;
import com.github.houbb.retry.common.service.OutService;
import com.github.houbb.retry.common.service.UserService;
import com.github.houbb.retry.common.service.impl.AlwaysFailOutServiceImpl;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午7:25  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class UserServiceRetryImpl implements UserService {

    @Override
    public User queryUser(QueryUserCondition condition) {
        int times = 0;
        OutService outService = new AlwaysFailOutServiceImpl();

        while (times < RetryConstant.MAX_TIMES) {
            try {
                outService.remoteCall();
                return new User();
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

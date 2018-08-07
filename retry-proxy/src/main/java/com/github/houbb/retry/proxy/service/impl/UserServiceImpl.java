/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.proxy.service.impl;

import com.github.houbb.retry.common.condition.QueryUserCondition;
import com.github.houbb.retry.common.model.User;
import com.github.houbb.retry.common.service.OutService;
import com.github.houbb.retry.common.service.UserService;
import com.github.houbb.retry.common.service.impl.AlwaysFailOutServiceImpl;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午7:22  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class UserServiceImpl implements UserService {

    private OutService outService;

    public UserServiceImpl() {
        this(new AlwaysFailOutServiceImpl());
    }

    public UserServiceImpl(OutService outService) {
        this.outService = outService;
    }

    @Override
    public User queryUser(QueryUserCondition condition) {
        outService.remoteCall();
        return new User();
    }

}

/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.common.service;

import com.github.houbb.retry.common.condition.QueryUserCondition;
import com.github.houbb.retry.common.model.User;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午6:56  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public interface UserService {

    /**
     * 根据条件查询用户信息
     * @param condition 条件
     * @return User 信息
     */
    User queryUser(QueryUserCondition condition);

}

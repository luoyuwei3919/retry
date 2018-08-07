/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.aop.service;

import com.github.houbb.retry.common.service.UserService;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午11:22  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public interface MyUserService extends UserService {

    /**
     * 两次
     */
    void twoTimes();

    /**
     * 五次测试
     */
    void fiveTimes();

    /**
     * 异常类型
     */
    void exceptionClass();

}

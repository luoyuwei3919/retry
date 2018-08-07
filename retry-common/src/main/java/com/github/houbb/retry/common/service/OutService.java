/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.common.service;

import com.github.houbb.retry.common.model.User;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午7:29  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public interface OutService {

    /**
     * 外部调用
     * @return 用户信息
     */
    void remoteCall();

}

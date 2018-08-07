/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.dynamic.proxy.service.impl;

import com.github.houbb.retry.common.model.User;
import com.github.houbb.retry.common.service.OutService;
import com.github.houbb.retry.common.service.impl.AlwaysFailOutServiceImpl;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午9:51  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class ResourceServiceImpl {

    /**
     * 校验资源信息
     * @param user 入参
     * @return 是否校验通过
     */
    public boolean checkResource(User user) {
        OutService outService = new AlwaysFailOutServiceImpl();
        outService.remoteCall();
        return true;
    }

}

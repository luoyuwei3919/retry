/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.dynamic.proxy.service.impl;

import com.github.houbb.retry.common.model.User;
import com.github.houbb.retry.common.service.OutService;
import com.github.houbb.retry.common.service.impl.AlwaysFailOutServiceImpl;
import com.github.houbb.retry.dynamic.proxy.service.RoleService;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午9:45  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class RoleServiceImpl implements RoleService {

    @Override
    public boolean hasPrivilege(User user) {
        OutService outService = new AlwaysFailOutServiceImpl();
        outService.remoteCall();
        return true;
    }

}

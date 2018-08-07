/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.dynamic.proxy.service;

import com.github.houbb.retry.common.model.User;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午9:43  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public interface RoleService {

    /**
     * 查询
     * @param user 用户信息
     * @return 是否拥有权限
     */
    boolean hasPrivilege(User user);

}

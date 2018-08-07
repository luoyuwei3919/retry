/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.common.service.impl;

import com.github.houbb.retry.common.service.OutService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午7:30  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class AlwaysFailOutServiceImpl implements OutService {

    private static final Logger LOGGER = LogManager.getLogger(AlwaysFailOutServiceImpl.class);

    @Override
    public void remoteCall() {
        LOGGER.error("外部调用失败...");
        throw new RuntimeException();
    }

}

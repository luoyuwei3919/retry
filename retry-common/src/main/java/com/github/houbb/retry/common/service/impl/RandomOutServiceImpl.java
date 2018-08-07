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
public class RandomOutServiceImpl implements OutService {

    private static final Logger LOGGER = LogManager.getLogger(RandomOutServiceImpl.class);

    /**
     * 成功的百分比
     */
    private int successPercent;

    public RandomOutServiceImpl(int successPercent) {
        if(successPercent < 0 || successPercent > 100) {
            throw new IllegalArgumentException();
        }
        this.successPercent = successPercent;
    }


    @Override
    public void remoteCall() {
        // 随机数
        int randomNum = (int)(Math.random()*100+1);
        if(randomNum <= successPercent) {
            LOGGER.info("外部调用成功...");
            return;
        }

        LOGGER.error("外部调用失败...");
        throw new RuntimeException();
    }

}

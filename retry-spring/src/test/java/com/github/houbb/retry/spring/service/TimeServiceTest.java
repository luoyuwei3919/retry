/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.spring.service;

import com.github.houbb.retry.spring.model.CbTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午11:54  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TimeServiceTest {

    @Autowired
    private TimeService timeService;

    @Test
    public void test() {
        CbTime cbTime = new CbTime();
        cbTime.setMsg(0);
        cbTime.setTime(1);
        timeService.call(cbTime);
    }

}

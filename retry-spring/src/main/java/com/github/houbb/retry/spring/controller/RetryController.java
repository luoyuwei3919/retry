/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.spring.controller;


import com.github.houbb.retry.spring.model.CbTime;
import com.github.houbb.retry.spring.service.RemoteService;
import com.github.houbb.retry.spring.service.TimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/6/23 上午11:22  </pre>
 * <pre> Project: spring-boot  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@RestController
@RequestMapping("/retry")
public class RetryController {

    private final RemoteService remoteService;

    private final TimeService timeService;

    @Autowired
    public RetryController(RemoteService remoteService, TimeService timeService) {
        this.remoteService = remoteService;
        this.timeService = timeService;
    }

    /**
     * 重试方法
     * @return http result
     */
    @RequestMapping("/")
    public ResponseEntity retry() {
        remoteService.call();
        return ResponseEntity.ok("you get it");
    }

    /**
     * 重试方法
     * @return http result
     */
    @RequestMapping("/time")
    public ResponseEntity retryTime() {
        CbTime cbTime = new CbTime();
        cbTime.setTime(1);
        cbTime.setMsg(0);
        timeService.call(cbTime);
        return ResponseEntity.ok("you get it");
    }

}

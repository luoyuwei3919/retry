/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/6/23 上午11:14  </pre>
 * <pre> Project: spring-boot  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@SpringBootApplication
@EnableRetry
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("Retry start at http://localhost:18080/retry/");
        System.out.println("Time start at http://localhost:18080/retry/time");
    }

}

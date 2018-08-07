/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.aop.config;

import com.github.houbb.retry.common.service.OutService;
import com.github.houbb.retry.common.service.impl.AlwaysFailOutServiceImpl;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import static com.github.houbb.retry.aop.config.SpringConfig.PACKAGE_SCAN;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午9:28  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@Configurable
@EnableAspectJAutoProxy
@ComponentScan(basePackages = PACKAGE_SCAN)
public class SpringConfig {

    static final String PACKAGE_SCAN = "com.github.houbb.retry.aop";

    @Bean
    public OutService outServiceBean() {
        return new AlwaysFailOutServiceImpl();
    }

}

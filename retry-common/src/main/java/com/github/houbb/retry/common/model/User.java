/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.common.model;

import lombok.Data;
import lombok.ToString;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午6:04  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@Data
public class User {

    /**
     * 名称
     */
    private String name;

    /**
     * 爱好
     */
    private String hobby;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}

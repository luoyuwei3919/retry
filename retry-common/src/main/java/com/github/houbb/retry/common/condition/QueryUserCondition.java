/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.common.condition;

import lombok.Builder;
import lombok.Data;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午6:08  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@Data
@Builder
public class QueryUserCondition {

    /**
     * 用户标识
     */
    private Long userId;

    /**
     * 次数
     */
    private int times;

}

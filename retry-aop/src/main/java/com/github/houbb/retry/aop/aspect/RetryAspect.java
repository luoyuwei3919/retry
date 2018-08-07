/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.aop.aspect;

import com.github.houbb.retry.aop.annotation.Retryable;
import com.github.houbb.retry.aop.exception.AopRuntimeExption;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午9:32  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
@Aspect
@Component
public class RetryAspect {

    @Pointcut("execution(public * com.github.houbb.retry.aop..*.*(..)) &&" +
                      "@annotation(com.github.houbb.retry.aop.annotation.Retryable)")
    public void myPointcut() {
    }

    @Around("myPointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Method method = getCurrentMethod(point);
        Retryable retryable = method.getAnnotation(Retryable.class);

        //1. 最大次数判断
        int maxAttempts = retryable.maxAttempts();
        if (maxAttempts <= 1) {
            return point.proceed();
        }

        //2. 异常处理
        int times = 0;
        final Class<? extends Throwable> exceptionClass = retryable.value();
        while (times < maxAttempts) {
            try {
                return point.proceed();
            } catch (Throwable e) {
                times++;

                // 超过最大重试次数 or 不属于当前处理异常
                if (times >= maxAttempts ||
                        !e.getClass().isAssignableFrom(exceptionClass)) {
                    throw new Throwable(e);
                }
            }
        }

        return null;
    }

    private Method getCurrentMethod(ProceedingJoinPoint point) {
        try {
            Signature sig = point.getSignature();
            MethodSignature msig = (MethodSignature) sig;
            Object target = point.getTarget();
            return target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(RuntimeException.class.isAssignableFrom(AopRuntimeExption.class));
        System.out.println(AopRuntimeExption.class.isAssignableFrom(RuntimeException.class));
    }

}

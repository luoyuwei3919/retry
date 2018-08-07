/*
 * Copyright (c)  2018. houbinbin Inc.
 * retry All rights reserved.
 */

package com.github.houbb.retry.dynamic.proxy.cglib;

import com.github.houbb.retry.common.constant.RetryConstant;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/7 下午10:36  </pre>
 * <pre> Project: retry  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        int times = 0;

        while (times < RetryConstant.MAX_TIMES) {
            try {
                //通过代理子类调用父类的方法
                return methodProxy.invokeSuper(o, objects);
            } catch (Exception e) {
                times++;

                if (times >= RetryConstant.MAX_TIMES) {
                    throw new RuntimeException(e);
                }
            }
        }

        return null;
    }

    /**
     * 获取代理类
     * @param clazz 类信息
     * @return 代理类结果
     */
    public Object getProxy(Class clazz){
        Enhancer enhancer = new Enhancer();
        //目标对象类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术创建目标对象类的子类实例作为代理
        return enhancer.create();
    }


}

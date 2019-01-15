package com.man1s.spring.aop.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Title:TestMethodInteceptor
 * Description:
 * Company:北京华宇元典信息服务有限公司
 *
 * @author:wangjiyu
 * @version:1.0
 * @date:2019/1/15 14:08
 */
public class TestMethodInteceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib intercept 执行类：" + o.getClass().getName() + "     执行方法：" + methodProxy.getSuperName());
        Object obj = methodProxy.invokeSuper(o, objects);
        return obj;
    }
}

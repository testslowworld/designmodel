package com.man1s.spring.aop.cglib;


import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * Title:TestClient
 * Description:
 * Company:北京华宇元典信息服务有限公司
 *
 * @author:wangjiyu
 * @version:1.0
 * @date:2019/1/15 14:13
 */
public class TestClient {
    public static void main(String[] args) {
        // 代理类class文件存入本地磁盘方便我们反编译查看源码
        //测试git - reset id
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(com.man1s.spring.aop.cglib.TestService.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new TestMethodInteceptor());
        // 创建代理对象
        TestService proxy = (TestService) enhancer.create();
        // 通过代理对象调用目标方法
        //        proxy.sayHello();
        proxy.sayHi();
    }
}

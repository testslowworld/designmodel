package com.man1s.spring.aop.cglib;

/**
 * Title:TestService
 * Description:
 * Company:北京华宇元典信息服务有限公司
 *
 * @author:wangjiyu
 * @version:1.0
 * @date:2019/1/15 14:06
 */
public class TestService {

    public TestService() {
        System.out.println("init TestService");
    }

    public void sayHello() {
        System.out.println("hello");
    }

    public final void sayHi() {
        System.out.println("hi");
    }
}

package com.thunisoft.hyyd.DesignModel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class Proxy {
    public static void main(String[] args) {
        //        testJdkProxy();
        testCglibProxy();

    }

    public static void testCglibProxy() {
        User target = new User();

        User proxy = (User) new CglibProxy(target).getProxyInstance();

        proxy.name();
    }

    public static void testJdkProxy() {
        Device device = new MobilePhone();
        InvocationHandler h = new Handler(device);
        device = (Device) java.lang.reflect.Proxy.newProxyInstance(device.getClass().getClassLoader(), device
                .getClass().getInterfaces(), h);
        device.doSome();
    }
}

//设备接口类
interface Device{
    void doSome();
}

class MobilePhone implements Device {

    @Override
    public void doSome() {
        System.out.println("mobile for call");
    }

}

class Handler implements InvocationHandler {
    private Object target;

    public Handler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(target, args);
        return null;
    }

}
class User{
    public void name(){
        System.out.println("name");
    }
}

class CglibProxy implements MethodInterceptor {

    private Object obj;

    public Object getProxyInstance() {
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(obj.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();

    }

    public CglibProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        return method.invoke(this.obj, args);
    }

}
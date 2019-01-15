package com.man1s.Thread;
public class ThreadLocalDemo {

    public static ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "调用initialValue方法初始化的值";
        }
    };

    public static void main(String[] args) {
        ThreadLocalDemo.THREAD_LOCAL.set("与main线程关联的字符串");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1线程从ThreadLocal中获取的值：" + ThreadLocalDemo.THREAD_LOCAL.get());
                ThreadLocalDemo.THREAD_LOCAL.set("与t1线程关联的字符串");
                System.out.println("t1线程再次从ThreadLocal中获取的值：" + ThreadLocalDemo.THREAD_LOCAL.get());
            }
        }, "t1").start();

        System.out.println("main线程从ThreadLocal中获取的值：" + ThreadLocalDemo.THREAD_LOCAL.get());
    }
}
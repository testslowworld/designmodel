package com.man1s.designmodel;

public class Singleton {
    public static void TestStaticInnerClass() {
        for (int i = 0; i < 2; i++) {
            System.out.println(StaticInnerClass.getInstance());
        }
    }

    public static void main(String[] args) {
        TestStaticInnerClass();
    }

}

class StaticInnerClass {
    static class Inner {
        private static StaticInnerClass inner = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance() {
        return StaticInnerClass.Inner.inner;
    }

    private StaticInnerClass() {
        System.out.println("运行构造函数");
    }

}
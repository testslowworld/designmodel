package com.thunisoft.hyyd.DesignModel;

public class Template {
    public static void main(String[] args) {
        Sing jack = new Jack();
        jack.start();
        Sing zhou = new Zhou();
        zhou.start();
    }

}

abstract class Sing {
    public void start() {
        preSing();
        sing();
        postSing();
    }

    public abstract void sing();

    public void preSing() {
        System.out.println("准备唱歌");
    }

    public void postSing() {
        System.out.println("唱歌完成");
    }
}

class Zhou extends Sing {

    @Override
    public void sing() {
        System.out.println("周董唱歌");
    }

}

class Jack extends Sing {

    @Override
    public void sing() {
        System.out.println("jack 唱歌");
    }

}

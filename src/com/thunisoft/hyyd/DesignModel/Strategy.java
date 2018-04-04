package com.thunisoft.hyyd.DesignModel;

public class Strategy {
    public static void main(String[] args) {
        new InvocateSing(new Zhous()).start();
        new InvocateSing(new Jacks()).start();
    }

}

class InvocateSing {
    private Sings sings;

    public InvocateSing(Sings sings) {
        this.sings = sings;
    }

    void start() {
        sings.preSing();
        sings.Sing();
        sings.postSing();
    }
}
interface Sings {
    void preSing();

    void Sing();

    void postSing();
}

class Zhous implements Sings {

    @Override
    public void preSing() {
        System.out.println("周董准备唱歌");
    }

    @Override
    public void Sing() {
        System.out.println("周董唱歌");
    }

    @Override
    public void postSing() {
        System.out.println("周董结束唱歌");
    }

}

class Jacks implements Sings {

    @Override
    public void preSing() {
        System.out.println("Jack准备唱歌");
    }

    @Override
    public void Sing() {
        System.out.println("Jack唱歌");
    }

    @Override
    public void postSing() {
        System.out.println("Jack结束唱歌");
    }

}

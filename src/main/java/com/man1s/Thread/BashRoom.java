package com.man1s.Thread;


public class BashRoom {
    public static void main(String[] args) {
        BashRoom bash = new BashRoom();
        new Thread(new Go(bash,"a")).start();
        new Thread(new Go(bash, "b")).start();
        new Thread(new Go(bash, "c")).start();
        new Thread(new Go(bash, "d")).start();
        BashRoom.sleep(2000);

        new Thread(new Fix(bash)).start();
    }

    public static void sleep(long times) {
        try {
            Thread.sleep(times);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void wait(Object obj) {
        try {
            obj.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private boolean right = false;

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

}

class Fix implements Runnable {
    private BashRoom bashroom;

    public Fix(BashRoom bashroom) {
        super();
        this.bashroom = bashroom;
    }


    @Override
    public void run() {
        synchronized (bashroom) {
            BashRoom.sleep(2000);
            bashroom.setRight(true);
            bashroom.notifyAll();
        }
        System.out.println("修好了-------------");
    }

}

class Go implements Runnable {
    private BashRoom bashroom;

    private String name;

    public Go(BashRoom bashroom, String name) {
        super();
        this.bashroom = bashroom;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (bashroom) {
            while (!bashroom.isRight()) {
                System.out.println(name + "  ===========着急呀");
                BashRoom.wait(bashroom);
            }
            System.out.println(name + "  ===========hahhaa");
        }
    }

}

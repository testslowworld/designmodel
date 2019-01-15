package com.man1s.Thread;

public class Test implements Runnable {

    public int i = 0;

    @Override
    public void run() {
        System.out.println(i++);

    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Test()).start();
        }
    }

}

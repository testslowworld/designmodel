package com.thunisoft.hyyd.DesignModel;

public class Singleton {
    
    private Singleton() {}
    
    static class Single{
        private static Singleton getInstance = new Singleton();
    }
    
    public static void main(String[] args) {
        Singleton s = Singleton.Single.getInstance;
    }

}

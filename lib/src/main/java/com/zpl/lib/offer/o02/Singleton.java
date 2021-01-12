package com.zpl.lib.offer.o02;

/**
 * 单例模式
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton() {
    }

    /**
     * 懒汉式
     */
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

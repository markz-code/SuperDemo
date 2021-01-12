package com.zpl.lib.offer.o02;

/**
 * 静态内部类
 */
public class Singleton3 {

    private Singleton3() {
    }

    private static class Nested {
        private static final Singleton3 singleton3 = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return Nested.singleton3;
    }
}

package com.zpl.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现生产者和消费者模式
 */
public class MyClass {

    private static Integer count = 0;
    // 缓存池大小
    private static final Integer FULL = 10;
    private static final String LOCK = "lock";

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
       new Thread(myClass.new Producer()).start();
       new Thread(myClass.new Producer()).start();
       new Thread(myClass.new Producer()).start();
       new Thread(myClass.new Producer()).start();
       new Thread(myClass.new Consumer()).start();
       new Thread(myClass.new Consumer()).start();
       new Thread(myClass.new Consumer()).start();
       new Thread(myClass.new Consumer()).start();
    }

    class Producer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count.equals(FULL)) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    LOCK.notify();
                }
            }
        }
    }


    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}

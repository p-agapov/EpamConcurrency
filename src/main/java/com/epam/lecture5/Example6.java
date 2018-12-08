package com.epam.lecture5;

import lombok.Synchronized;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

public class Example6 {

    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {

        CounterWithPrivateLock counter = new CounterWithPrivateLock();

        Field lockField = CounterWithPrivateLock.class.getDeclaredField("$lock");
        lockField.setAccessible(true);
        Object lock = lockField.get(counter);

        System.out.println(lock);

        Thread incThread = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.inc();
            }
            System.out.println("Inc end");
        });
        Thread decThread = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.dec();
            }
            System.out.println("Dec end");
        });

        incThread.start();
        decThread.start();

        synchronized (lock) {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("After sleep");
        }

        incThread.join();
        decThread.join();

        System.out.println(counter.getValue());
    }
}

class CounterWithPrivateLock {

    private volatile int value = 0;
//    private final Object lock = new Object();

//    void inc() {
//        synchronized (lock) {
//            value++;
//        }
//    }
//
//    void dec() {
//        synchronized (lock) {
//            value--;
//        }
//    }

    @Synchronized
    void inc() {
            value++;
    }

    @Synchronized
    void dec() {
            value--;
    }

    public int getValue() {
        return value;
    }
}

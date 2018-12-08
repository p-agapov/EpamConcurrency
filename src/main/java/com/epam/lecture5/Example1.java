package com.epam.lecture5;

public class Example1 {

    private static volatile long value = 0;

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        Runnable inc = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                //critical section
                synchronized (lock) {
                    value++;
                }
            }
        };

        Runnable dec = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                synchronized (lock) {
                    value--;
                }
            }
        };

        Thread incThread = new Thread(inc);
        Thread dec1Thread = new Thread(dec);
        Thread dec2Thread = new Thread(dec);

        incThread.start();
        dec1Thread.start();
        dec2Thread.start();

        incThread.join();
        dec1Thread.join();
        dec2Thread.join();

        System.out.println(value);
    }
}

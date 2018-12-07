package com.epam.lecture4;

import java.util.concurrent.TimeUnit;

public class Example5 {
    private static long value = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread counter = new Thread(() -> {
            for (long i = 0L; i < 1_000_000_000L; i++) {
                if (Thread.interrupted()) {
                    return;
                }
                value++;
            }
            System.out.println(value);
        });

        counter.start();

        TimeUnit.SECONDS.sleep(1);
        counter.interrupt();

        System.out.println(value);
    }
}

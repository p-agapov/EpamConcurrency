package com.epam.lecture5;

import java.util.concurrent.TimeUnit;

public class Example2 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                System.out.println("Before sleep");
                TimeUnit.SECONDS.sleep(3);
                System.out.println("After sleep");
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + Thread.currentThread().isInterrupted());
            }
        });

        thread.start();

        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}

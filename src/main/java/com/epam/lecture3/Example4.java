package com.epam.lecture3;

import java.util.concurrent.TimeUnit;

public class Example4 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.printf("Before start: %s%n", thread.getState());

        thread.start();

        System.out.printf("Before sleep: %s%n", thread.getState());

        TimeUnit.SECONDS.sleep(1);

        System.out.printf("Before join: %s%n", thread.getState());

        thread.join();

        System.out.printf("End: %s%n", thread.getState());
    }
}

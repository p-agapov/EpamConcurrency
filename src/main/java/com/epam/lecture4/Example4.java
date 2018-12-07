package com.epam.lecture4;

import java.util.concurrent.TimeUnit;

public class Example4 {

    public static void main(String[] args) throws InterruptedException {
        Thread daemon = new Thread(() -> {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().isDaemon());
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Hello from daemon");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        daemon.setDaemon(true);
        daemon.start();

        TimeUnit.SECONDS.sleep(3);
    }
}

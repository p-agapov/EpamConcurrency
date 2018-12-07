package com.epam.lecture4;

import java.util.concurrent.TimeUnit;

public class Example1 {

    private static long value = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable counter = () -> {
            for (int i = 0; i < 1_000_000_000; i++) {
                ++value;
            }
        };

        Thread thread = new Thread(counter);
        thread.start();

//        busy wait
//        while (thread.getState() != Thread.State.TERMINATED); - постоянный опрос потока занимает одно ядро
        while (thread.isAlive()) {
            TimeUnit.MILLISECONDS.sleep(500);
        }

        System.out.println(value);
    }
}

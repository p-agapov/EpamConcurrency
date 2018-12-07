package com.epam.lecture3;

import java.util.concurrent.TimeUnit;

public class Example3 {

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        Runnable task = () -> {
          long value = 0;
          while (!Thread.interrupted()) {
              ++value;
              Thread.yield();
          }
            System.out.printf("Thread %s value = %d%n", Thread.currentThread(), value);
        };

        Thread[] counters = new Thread[Runtime.getRuntime().availableProcessors() + 2];
        for (int i = 0; i < counters.length; i++) {
            counters[i] = new Thread(task);

            if (i < 4) {
                counters[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                counters[i].setPriority(Thread.MIN_PRIORITY);
            }
        }

        counters[0].setPriority(Thread.MIN_PRIORITY);

        for (Thread counter: counters) {
            counter.start();
        }

        TimeUnit.SECONDS.sleep(3);

        for (Thread counter : counters) {
            counter.interrupt();
        }

        System.out.println("End main");
    }
}

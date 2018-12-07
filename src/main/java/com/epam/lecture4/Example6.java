package com.epam.lecture4;

import java.util.concurrent.TimeUnit;

public class Example6 {

    enum ThreadState {
        RUNNING,
        PAUSED,
        STOPPED
    }

    private static volatile ThreadState state;
    private static volatile long value;


    public static void main(String[] args) throws InterruptedException {
        Runnable counter = () -> {
            while (true) {
                switch (state) {
                    case RUNNING:
                        value++;
                        break;
                    case PAUSED:
                        break;
                    case STOPPED:
                        return;
                }
            }
        };

        Thread counterThread = new Thread(counter);
        state = ThreadState.RUNNING;
        counterThread.start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println(counterThread.getState());

        System.out.printf("Value before pause = %d%n", value);
        state = ThreadState.PAUSED;
        TimeUnit.SECONDS.sleep(1);
        System.out.printf("Value after pause = %d%n", value);

        state = ThreadState.STOPPED;
        System.out.println(counterThread.getState());

        System.out.printf("Value end = %d%n", value);
        System.out.println("Main end");
    }
}

package com.epam.lecture4;

public class Example7 {

    private static volatile long value = 0;

    public static void main(String[] args) throws InterruptedException {

        Runnable inc = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                value++;
            }
        };

        Runnable dec = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                value--;
            }
        };

        Thread incThread = new Thread(inc);
        Thread decThread = new Thread(dec);

        incThread.start();
        decThread.start();

        incThread.join();
        decThread.join();

        System.out.println(value);
    }
}

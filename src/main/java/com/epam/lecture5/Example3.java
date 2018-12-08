package com.epam.lecture5;

public class Example3 {

    private static volatile Long value = 0L;

    public static void main(String[] args) throws InterruptedException {

        Runnable inc = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                //critical section
                synchronized (value) {
                    value++;
                }
            }
        };

        Runnable dec = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                synchronized (value) {
                    value--;
                }
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

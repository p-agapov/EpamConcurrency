package com.epam.lecture5;

public class Example5 {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Thread incThread = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.inc();
            }
        });
        Thread decThread = new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.dec();
            }
        });

        incThread.start();
        decThread.start();


        incThread.join();
        decThread.join();

        System.out.println(counter.getValue());
    }
}

class Counter {

    private volatile int value = 0;

    synchronized static void outer() {
        System.out.println("Outer synchronized");
    }

    static void inner() {
        synchronized (Counter.class) {
            System.out.println("Inner synchronized");
        }
    }

    synchronized void inc() {
        value++;
    }

    void dec() {
        synchronized (this) {
            value--;
        }
    }

    public int getValue() {
        return value;
    }
}

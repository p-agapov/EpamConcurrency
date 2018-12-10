package com.epam.lecture6;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Example2 {

    public static void main(String[] args) {

        Object a = new Object();
        Object b = new Object();

        new Thread(new Runnable() {
            @Override
            @SneakyThrows
            public void run() {
                synchronized (a) {
                    TimeUnit.SECONDS.sleep(1);
                    synchronized (b) {
                        System.out.println("(1) Got it!");
                    }
                }
            }
        }, "Thread-1").start();

        new Thread(new Runnable() {
            @Override
            @SneakyThrows
            public void run() {
                synchronized (b) {
                    TimeUnit.SECONDS.sleep(1);
                    synchronized (a) {
                        System.out.println("(2) Got it!");
                    }
                }
            }
        }, "Thread-2").start();
    }
}

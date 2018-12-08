package com.epam.lecture5;

import java.util.concurrent.TimeUnit;

public class Example7 {

    public static void main(String[] args) throws InterruptedException {

//        A a = new A();
        A a = new B();
        Thread main = Thread.currentThread();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                main.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        synchronized (a) {
            Thread thread = new Thread(() -> {
                a.method();
            });
            thread.start();
            thread.join();
        }
    }
}

class A {

    public synchronized void method() {
        System.out.println("Synchronized method");
    }
}

class B extends A {
    @Override
    public void method() {
        System.out.println("Non-synchronized method");
    }
}

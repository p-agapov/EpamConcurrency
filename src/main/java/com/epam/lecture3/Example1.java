package com.epam.lecture3;

public class Example1 {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        System.out.println(main.getId());
        System.out.println(main);

        HelloWorldThread task1 = new HelloWorldThread();
        task1.setName("Task1");
        System.out.println(task1.getId());
        task1.start();

        Runnable  task2 = () -> System.out.println("Hello from thread: " + Thread.currentThread());
        Thread thread = new Thread(task2);
        System.out.println(thread.getId());
        thread.setName("Task2");
        thread.start();
    }
}

class HelloWorldThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from thread: " + Thread.currentThread());
    }
}

package com.epam.lecture2;

public class Example2 {
    public static void main(String[] args) {
//        Default uncaught exception handler overriding.
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> System.out.println("New default handler!"));

        Thread main = Thread.currentThread();
        main.setUncaughtExceptionHandler((t, e) -> System.out.println("New handler for thread main!"));
        System.out.println(main);

        ThreadGroup threadGroup = main.getThreadGroup();
        System.out.println(threadGroup);

        method1();
    }

    private static void method1() {
        try {
            method2();
        } catch (RuntimeException ex) {
            ex.fillInStackTrace();              //refill stacktrace
            throw ex;
        }
    }

    private static void method2() {
        throw new RuntimeException("Hello from method 2");
    }
}

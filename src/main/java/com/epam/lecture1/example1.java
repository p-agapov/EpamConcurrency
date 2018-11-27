package com.epam.lecture1;

public class example1 {

    private int field = 42;

    public static void main(String[] args) {
        //CAFEBABE
        System.out.println("Hello World!");

        for (int i =0; i < 10; i++) {
            System.out.println(String.format("i= %d", i));
        }
    }
}

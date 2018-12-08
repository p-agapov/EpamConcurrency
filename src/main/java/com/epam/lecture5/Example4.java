package com.epam.lecture5;

public class Example4 {

    public static void main(String[] args) {

        int a1 = 10;
        int b1 = 10;
        System.out.println(a1 == b1);

        Integer a2 = 10;
        int b2 = 10;
        System.out.println(a2 == b2);

        Integer a3 = 10;
        Integer b3 = 10;
        System.out.println(a3 == b3);

        Integer a4 = 10;
        Integer b4 = 9;
        System.out.println(a4 == ++b4);
    }
}

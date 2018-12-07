package com.epam.lecture1;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import static java.lang.System.out;

public class Example2 {

    //HEAP
    //NON-HEAP
    public static void main(String[] args) {
        A a = new A();

        System.out.println(a);

        int[] arr = {1, 2, 3};
//          int[] arr = new int[]{1, 2, 3}; неявно
//          12 - заголовок
//          4 - размер массива
//          12 - под элементы

        A[] objArr = {new A(), new A(), new A()};
//              [12 + 4 + {ref, ref, ref}]
//                          |
//                          [12 + 4 + 2 +6]

        out.println(VM.current().details());
        out.println(ClassLayout.parseClass(A.class).toPrintable());
    }
}

//byte      1
//short     2
//int       4
//long      8
//float     4
//double    8
//char      2
//boolean   ? (1)
//reference ? (4 - 32-bit, 8 - 64-bit)

class A {

    //header:
    //8 - 32-bit
    //12 - 64-bit

    private int field1;                         //4
    private short field2;                       //2
    //padding - выравнивание объекта в памяти   //6
}

//24 = 12 + 6 + 6 - заголовок + данные + выравнивание
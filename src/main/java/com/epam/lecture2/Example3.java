package com.epam.lecture2;

import java.util.concurrent.TimeUnit;

public class Example3 {

    public static void main(String[] args) throws InterruptedException {
        int[][] arr = new int[1000][];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[1_000_000];
            TimeUnit.SECONDS.sleep(1);
        }
    }
}

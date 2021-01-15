package com.zpl.lib.offer.o10;

/**
 * 斐波那契数列
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(fibonacci(4));
    }

    private static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int pre1 = 0;
        int pre2 = 1;

        int num = 0;
        for (int i = 2; i <= n; i++) {
            num = pre1 + pre2;
            pre1 = pre2;
            pre2 = num;
        }
        return num;
    }

}
package com.zpl.lib.offer.o15;

/**
 * 二进制中1的个数
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(numberOf1_2(-2));
    }

    private static int numberOf1_2(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}

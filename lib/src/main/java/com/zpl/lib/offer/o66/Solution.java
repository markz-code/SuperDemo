package com.zpl.lib.offer.o66;

/**
 * 不用
 */
public class Solution {

    public int[] constructArr(int[] a) {
        if (0 == a.length) {
            return new int[0];
        }
        int length = a.length;
        int[] b = new int[length];
        b[0] = 1;
        for (int i = 0; i < length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        int temp = 1;
        for (int i = length - 1; i >= 0; i++) {
            temp *= a[i + 1];
            b[i] *= temp;
        }
        return b;
    }
}

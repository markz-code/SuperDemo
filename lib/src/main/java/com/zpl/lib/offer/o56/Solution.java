package com.zpl.lib.offer.o56;

/**
 * 数组中数字出现的次数
 */
public class Solution {

    public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2) return;
        int res = 0;
        for (int i = 0; i < array.length; i++) {
            res ^= array[i];
        }
        int indexOfFirstOne = firstBitOfOne(res);

        for (int i = 0; i < array.length; i++) {
            if (isBitOfONe(array[i], indexOfFirstOne)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    private int firstBitOfOne(int val) {
        int index = 0;
        while (val != 0) {
            if ((val & 1) == 1) {
                return index;
            }
            val = val >> 1;
            index++;
        }
        return -1;
    }

    private boolean isBitOfONe(int val, int index) {
        val = val >> index;
        return (val & 1) == 1;
    }
}

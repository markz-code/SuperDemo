package com.zpl.lib.offer.o42;

/**
 * 连续子数组的最大和
 */
public class Solution {

    public int findGreatSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int max = array[0];

        int curMax = max;
        for (int i = 1; i < array.length; i++) {
            if(curMax <= 0) {
                curMax = array[i];
            } else {
                curMax += array[i];
            }
            if(curMax > max) {
                max = curMax;
            }
        }
        return max;
    }
}

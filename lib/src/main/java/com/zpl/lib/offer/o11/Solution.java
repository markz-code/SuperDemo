package com.zpl.lib.offer.o11;

/**
 * 旋转数组的最小数字
 * 二分查找
 */
public class Solution {

    public static void main(String[] args) {

    }

    private static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            // 最小值在mid右边
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] < array[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return array[low];
    }
}
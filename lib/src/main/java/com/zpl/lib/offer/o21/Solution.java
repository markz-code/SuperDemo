package com.zpl.lib.offer.o21;


import com.zpl.lib.offer.Constant;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 首尾双指针
 */
public class Solution {

    public static void main(String[] args) {
        int[] ints = reOrderArray(Constant.arr1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    private static int[] reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // 奇数
            if ((array[left] & 1) != 0) {
                left++;
                continue;
            }
            // 偶数
            if ((array[right] & 1) != 1) {
                right--;
                continue;
            }
            swap(left, right, array);
            left++;
            right--;
        }
        return array;
    }

    private static void swap(int i, int j, int[] array) {
        int value1 = array[i];
        array[i] = array[j];
        array[j] = value1;
    }
}
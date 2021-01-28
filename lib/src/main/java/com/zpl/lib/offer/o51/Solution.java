package com.zpl.lib.offer.o51;

/**
 * 数组中的逆序对
 */
public class Solution {

    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public int inversePairs(int[] array) {
        int count = 0;
        if (array == null || array.length == 0) {
            return count;
        }
        count = mergeSort(array, 0, array.length - 1);
        return count;
    }

    public int mergeSort(int[] array, int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = (low + high) >> 1;
        // 辅助数组
        int[] temp = new int[array.length];
        int left = mergeSort(array, low, mid);
        int right = mergeSort(array, mid + 1, high);
        count = left + right + merge(array, temp, low, mid, high);
        return count;
    }

    private int merge(int[] array, int[] temp, int low, int mid, int high) {
        int count = 0;
        int i = mid;
        int j = high;
        int k = high;
        while (i >= low && j >= mid + 1) {
            if (array[i] > array[j]) {
                temp[k--] = array[i--];
                count += j - mid;
            } else {
                temp[k--] = array[j--];
            }
        }
        while (i >= low) {
            temp[k--] = array[i--];
        }
        while (j >= mid + 1) {
            temp[k--] = array[j--];
        }
        System.arraycopy(temp, low, array, low, high - low + 1);
        return count;
    }
}

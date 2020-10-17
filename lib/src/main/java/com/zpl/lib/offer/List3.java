package com.zpl.lib.offer;

import java.util.HashMap;

public class List3 {

    public static void main(String[] args) {

    }

    /**
     * 哈希表
     * 时间复杂度 log(n) 空间复杂度 log(n)
     *
     * @param array
     * @return
     */
    public static int findDuplicate(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>(array.length);
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            if (map.get(temp) == null) {
                map.put(temp, i);
            } else {
                return temp;
            }
        }
        return -1;
    }

    /**
     * 利用题干信息——长度为n的数组里的所有数字都在0到n-1的范围内
     * 时间复杂度 log(n) 空间复杂度 log(1)
     *
     * @param numbers
     * @param length
     * @param duplication 将重复数字放入
     * @return
     */
    public static boolean findDuplicate2(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        // 超出范围的数字
        for (int i : numbers) {
            if (i < 0 || i < numbers.length - 1) {
                return false;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i , numbers[i]);
            }
        }
        return false;
    }

    private static void swap(int numbers[], int p, int q) {
        int temp = numbers[p];
        numbers[p] = numbers[q];
        numbers[q] = temp;
    }
}
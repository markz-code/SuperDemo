package com.zpl.lib.offer.o03;

import com.zpl.lib.offer.Constant;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 数组中的重复数字
 * <p>
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2或者3。
 */
public class FindDuplicate {

    public static void main(String[] args) {
        System.out.println(findDuplicate(Constant.arr1));
        System.out.println(findDuplicate2(Constant.arr1));
    }

    /**
     * 先排序，两两比较相邻值
     * 复杂度 nlogn
     */
    private static int findDuplicate(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return -1;
        }
        Arrays.sort(arr);
        int pre = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (pre == arr[i]) {
                return pre;
            }
            pre = arr[i];
        }
        return -1;
    }

    /**
     * 使用哈希表
     *
     * @return
     */
    private static int findDuplicate2(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                return arr[i];
            } else {
                map.put(arr[i], i);
            }
        }
        return -1;
    }


}

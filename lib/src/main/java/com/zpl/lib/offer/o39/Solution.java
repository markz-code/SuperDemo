package com.zpl.lib.offer.o39;

import com.zpl.lib.offer.Constant;

import java.util.HashMap;

/**
 * 数组中出现次数超过一半的数字
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(majorityElement(Constant.arrH));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("nums is null");
        }
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer value = map.get(num);
                if ((value + 1) > nums.length / 2) {
                    return num;
                }
                map.put(num, value + 1);
            } else {
                map.put(num, 1);
            }
        }
        return -1;
    }
}

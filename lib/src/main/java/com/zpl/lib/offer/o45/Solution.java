package com.zpl.lib.offer.o45;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 */
public class Solution {

    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        // 防止两个数相加溢出，将int变为String
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = nums[i] + "";
        }

        // 利用新的排序规则排序
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return (s + t1).compareTo(t1 + s);
            }
        });
        StringBuilder result = new StringBuilder();
        for (String s :
                strings) {
            result.append(s);
        }
        return result.toString();
    }

}

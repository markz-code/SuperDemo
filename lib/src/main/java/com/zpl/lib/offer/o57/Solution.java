package com.zpl.lib.offer.o57;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 两数之和
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s < target) i++;
            else if (s > target) j--;
            else return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }

    /**
     * 和为s的连续正数序列
     *
     * @param
     * @return
     */
    public List<List<Integer>> findContinuousSequence(int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (sum <= 0) {
            return result;
        }
        int small = 1;
        int big = 2;
        int cur = small + big;
        while (small <= sum / 2 && small < big) {
            if (cur == sum) {
                List<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                result.add(list);
                big++;
                cur += big;
            } else if (cur > sum) {
                cur -= small;
                small++;
            } else {
                big++;
                cur += big;
            }
        }
        return result;
    }
}
package com.zpl.lib.offer.o53;

/**
 * 在排序数组中查找数字
 * 排序--->二分查找
 */
public class Solution {

    public int search(int[] nums, int target) {
        // 搜索右边界
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int right = i;

        if (j >= 0 && nums[j] != target) return 0;

        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int left = j;
        return right - left - 1;
    }
}

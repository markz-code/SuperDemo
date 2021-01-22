package com.zpl.lib.offer.o40;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的k个数
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k >= arr.length) {
            return null;
        }
        int[] nums = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
        return nums;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] vec = new int[k];
        if(k == 0) {
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((integer, t1) -> t1 - integer);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if(queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            vec[i] = queue.poll();
        }
        return vec;
    }
}

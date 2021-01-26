package com.zpl.lib.offer.o41;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 */
public class Solution {
    /**
     * 大顶堆
     */
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1,o2) -> o2 - o1);
    /**
     * 小顶堆
     */
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    /**
     * 当前数据流读入的元素个数，用于判断奇偶
     */
    private int count = 0;

    public void insert(Integer num) {
        // 为了实现平衡分配，可以在数据的总数目是偶数时把数据插入最小堆，否则插入最大堆
        // 左右两个堆数目相差不超过1，先插入右，再插入左
        if((count & 1) == 0) {
            left.add(num);
            right.add(left.poll());
        } else {
            right.add(num);
            left.add(right.poll());
        }
        count++;
    }

    public Double getMedian() {
        if((count & 1) == 0) {
            return (left.peek() + right.peek())/2.0;
        } else {
            return (double)right.peek();
        }
    }
}

package com.zpl.lib.offer.o59;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值
 */
public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length < size || size <= 0) {
            return list;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int j = 0;
        for (int i = 0; i < num.length; i++) {
            maxHeap.offer(num[i]);
            if (maxHeap.size() >= size) {
                list.add(maxHeap.peek());
                // 直接移除对应数值
                maxHeap.remove(num[j++]);
            }
        }
        return list;
    }

    /**
     * 使用双端队列？？？？？？？？？？
     *
     * @param num
     * @param size
     * @return
     */
    public List<Integer> maxInWindow2(int[] num, int size) {
        List<Integer> list = new ArrayList<>();
        if (num == null || num.length < size || size <= 0) {
            return list;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
                deque.pollLast();
            }
            if (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            if (i + 1 >= size) {
                list.add(num[deque.peekFirst()]);
            }
        }
        return list;
    }


    /**
     * 队列的最大值
     */
    public class MaxQueue {
        private Deque<Integer> maxDeque = new LinkedList<>();
        private Deque<Integer> dataQueue = new LinkedList<>();

        public void offer(int number) {
            dataQueue.offerLast(number);
            if (maxDeque.isEmpty() || number > maxDeque.peekFirst()) {
                maxDeque.offerFirst(number);
            } else {
                maxDeque.offerFirst(maxDeque.peekFirst());
            }
        }

        public void poll() {
            if (dataQueue.isEmpty()) {
                throw new RuntimeException("deque is empty");
            }
            dataQueue.pollFirst();
            maxDeque.pollFirst();
        }

        public int max() {
            if (maxDeque.isEmpty()) {
                throw new RuntimeException("deque is empty");
            }
            return maxDeque.peekFirst();
        }
    }
}

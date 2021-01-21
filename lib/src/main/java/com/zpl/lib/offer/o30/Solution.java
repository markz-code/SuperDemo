package com.zpl.lib.offer.o30;

import java.util.LinkedList;

/**
 * 包含min方法的栈
 */
public class Solution {

    private LinkedList<Integer> stack = new LinkedList<>();
    // 辅助栈,用于存放最小值
    private LinkedList<Integer> minStack = new LinkedList<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty() || node < minStack.peek()) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return stack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return minStack.peek();
    }
}

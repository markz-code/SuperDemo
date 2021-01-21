package com.zpl.lib.offer.o31;

import java.util.LinkedList;

/**
 * 栈的压入、弹出序列
 */
public class Solution {

    private static boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0) {
            return false;
        }
        LinkedList<Integer> stackAux = new LinkedList<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            // 按照入栈序列依次压入辅助栈
            stackAux.push(pushA[i]);

            while (!stackAux.isEmpty() && stackAux.peek() == popA[popIndex]) {
                stackAux.pop();
                popIndex++;
            }
        }
        return stackAux.isEmpty();
    }
}
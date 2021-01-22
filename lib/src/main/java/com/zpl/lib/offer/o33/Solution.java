package com.zpl.lib.offer.o33;

/**
 * 二叉搜索树的后序遍历序列
 */
public class Solution {

    private static boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return isSearchBST(sequence, 0, sequence.length - 1);
    }

    private static boolean isSearchBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int rootVal = sequence[end];
        int i = start;

        while (i < end && sequence[i] < rootVal) {
            i++;
        }
        // 找到左右子树的边界
        int boundary = i;
        while (i < end) {
            // 右子树比根节点小，则false
            if (sequence[i] < rootVal) return false;
            i++;
        }
        return isSearchBST(sequence, start, boundary - 1) && isSearchBST(sequence, boundary, end - 1);
    }
}

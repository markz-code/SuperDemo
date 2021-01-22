package com.zpl.lib.offer.o36;

import com.zpl.lib.offer.Constant;

/**
 * 二叉搜索树与双向链表
 */
public class Solution {

    private static Constant.TreeNode lastNode;

    private static Constant.TreeNode convert(Constant.TreeNode pRootOfTree) {
        covertChild(pRootOfTree);
        Constant.TreeNode firstNode = lastNode;
        while (firstNode != null && firstNode.left != null) {
            firstNode = firstNode.left;
        }
        return firstNode;
    }

    /**
     * 中序遍历
     */
    private static void covertChild(Constant.TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return;
        }
        Constant.TreeNode current = pRootOfTree;
        if(current.left != null) {
            covertChild(current.left);
        }
        // 关键
        current.left = lastNode;
        if(lastNode != null) {
            lastNode.right = current;
        }
        lastNode = current;
        if(current.right != null) {
            covertChild(current.right);
        }
    }
}

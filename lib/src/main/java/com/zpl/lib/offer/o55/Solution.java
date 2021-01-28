package com.zpl.lib.offer.o55;

import com.zpl.lib.offer.Constant;

/**
 *
 */
public class Solution {

    /**
     * treeDepth
     */
    public int treeDepth(Constant.TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 是否为平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean isBalanced_Solution(Constant.TreeNode root) {
        if (root == null) {
            return true;
        }
        return treeDepth2(root) != -1;
    }

    private int treeDepth2(Constant.TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth2(root.left);
        if (left == -1) {
            return -1;
        }
        int right = treeDepth2(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }


}

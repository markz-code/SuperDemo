package com.zpl.lib.offer.o27;

import com.zpl.lib.offer.Constant;

/**
 * 对称的二叉树
 */
public class Solution {

    private static boolean isSymmetricalRecur(Constant.TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSymmetrical(root.left, root.right);
    }

    private static boolean isSymmetrical(Constant.TreeNode left, Constant.TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }
}

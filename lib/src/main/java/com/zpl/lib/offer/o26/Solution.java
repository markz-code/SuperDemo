package com.zpl.lib.offer.o26;

import com.zpl.lib.offer.Constant;

/**
 * 树的子结构
 */
public class Solution {
    public static void main(String[] args) {

    }

    private static boolean hasSubTree(Constant.TreeNode root1, Constant.TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = doesTree1HaveTree2(root1, root2);
            }
            if(!result) {
                result = hasSubTree(root1.left, root2);
            }
            if(!result) {
                result = hasSubTree(root1.right, root2);
            }
        }
        return result;
    }

    private static boolean doesTree1HaveTree2(Constant.TreeNode node1, Constant.TreeNode node2) {
        if(node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if(node1.val != node2.val) {
            return false;
        }
        return doesTree1HaveTree2(node1.left,node2.left)&&doesTree1HaveTree2(node1.right,node1.right);
    }
}

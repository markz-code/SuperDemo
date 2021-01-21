package com.zpl.lib.offer.o28;

import com.zpl.lib.offer.Constant;

/**
 * 交换左右子树
 */
public class Solution {

    private static void mirror(Constant.TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        Constant.TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        mirror(pRoot.left);
        mirror(pRoot.right);
    }
}

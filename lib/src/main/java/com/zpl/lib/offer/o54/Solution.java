package com.zpl.lib.offer.o54;

import com.zpl.lib.offer.Constant;

/**
 * 二叉搜索树的第K大的节点
 * 中序遍历倒叙
 */
public class Solution {

    int res, k;

    public int kthLargest(Constant.TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    void dfs(Constant.TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.right);
        if(k == 0) {
            return;
        }
        if(--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }
}

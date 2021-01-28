package com.zpl.lib.offer.o68;

import com.zpl.lib.offer.Constant.TreeNode;

/**
 *
 */
public class Solution {

    public TreeNode findLastSame(TreeNode root, TreeNode a, TreeNode b) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < a.val && cur.val < b.val) {
                cur = cur.left;
            } else if (cur.val > a.val && cur.val > b.val) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }
}

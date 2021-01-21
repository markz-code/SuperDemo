package com.zpl.lib.offer.o32;

import com.zpl.lib.offer.Constant;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 从上到下打印二叉树
 */
public class Solution {

    public static void main(String[] args) {

    }

    private static List<Integer> printFromTopToBottom(Constant.TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<Constant.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Constant.TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }
}

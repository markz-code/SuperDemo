package com.zpl.lib.offer.o07;

import com.zpl.lib.offer.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据前序遍历和中序遍历
 * 重建二叉树
 */
public class Solution {

    public static void main(String[] args) {
        Constant.TreeNode treeNode = buildTree(Constant.preorder, Constant.inorder);
    }

    private static Constant.TreeNode buildTree(int[] preOrder, int[] inOrder) {
        ArrayList<Integer> preOrderList = new ArrayList<>();
        ArrayList<Integer> inOrderList = new ArrayList<>();
        for (int i = 0; i < preOrder.length; i++) {
            preOrderList.add(preOrder[i]);
            inOrderList.add(inOrder[i]);
        }
        return buildTree(preOrderList, inOrderList);
    }

    private static Constant.TreeNode buildTree(List<Integer> preOrder, List<Integer> inOrder) {
        if (inOrder.isEmpty()) {
            return null;
        }

        /**
         * 前序遍历第一个节点就是根节点
         */
        Integer rootVal = preOrder.remove(0);

        // 创建根节点
        Constant.TreeNode root = new Constant.TreeNode(rootVal);

        // 递归构建左右子树
        // 先找到根节点在左右子树中的位置，进行划分
        int rootIndex = inOrder.indexOf(rootVal);

        // 构建左子树，范围 0-rootindex
        root.left = buildTree(preOrder, inOrder.subList(0, rootIndex));
        root.right = buildTree(preOrder, inOrder.subList(rootIndex + 1, inOrder.size()));

        return root;
    }

}

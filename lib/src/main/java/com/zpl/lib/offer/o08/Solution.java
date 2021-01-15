package com.zpl.lib.offer.o08;

/**
 * 二叉树中序遍历的下一个结点
 */
public class Solution {
    public static void main(String[] args) {

    }

    private static TreeLinkNode getNext(TreeLinkNode node) {
        if (node.right != null) {
            node = node.right;
            while(node.left != null) {
                node = node.left;
            }
            return node;
        }

        // 如果当前节点的右子树为空
        while (node.next != null && node.next.right == node) {
            node = node.next;
        }
        // 全是左子树
        return node.next;
    }

    private class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        // next指向父结点
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}

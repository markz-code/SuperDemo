package com.zpl.lib.offer;

public class Constant {

    public static int[] arr1 = {2, 3, 1, 0, 2, 5, 3};


    public static int[][] twoArr = {{1, 2, 8, 9},
            {2, 4, 6, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}};

    public static int[] preorder = {3, 9, 20, 15, 7};
    public static int[] inorder = {9, 3, 15, 20, 7};

    public static char[][] path = {
            {'a', 'b', 't', 'g'},
            {'c', 'f', 'c', 's'},
            {'j', 'd', 'e', 'h'}
    };

    public static char[] str = {'b','f','c','e'};

    /**
     * 链表 0 1 2 3 4
     */
    public static class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode getNode() {
            ListNode node0 = new ListNode(0);
            ListNode node1 = new ListNode(1);
            ListNode node2 = new ListNode(2);
            ListNode node3 = new ListNode(3);
            ListNode node4 = new ListNode(4);

            node0.next = node1;
            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            return node0;
        }
    }

    /**
     * 二叉树
     */
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

        public TreeNode() {
        }
    }

}

package com.zpl.lib.offer.o06;

import com.zpl.lib.offer.Constant;

/**
 * 从尾到头打印链表
 */
public class Solution {

    public static void main(String[] args) {
//        reverseListNode(new Constant.ListNode().getNode());
        reverseListNode2(new Constant.ListNode().getNode());
    }

    /**
     * 递归
     * 栈和递归一样
     * @param listNode
     */
    private static void reverseListNode(Constant.ListNode listNode) {
        if (listNode == null) {
            return;
        }
        reverseListNode(listNode.next);
        System.out.println(listNode.val);
    }

    /**
     * 反转链表 (重点)
     */
    private static void reverseListNode2(Constant.ListNode listNode) {
        if (listNode == null) {
            return;
        }
        Constant.ListNode pre = null;
        while (listNode != null) {
            Constant.ListNode next = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = next;
        }
        while (pre != null) {
            System.out.println(pre.val);
            pre = pre.next;
        }
    }
}

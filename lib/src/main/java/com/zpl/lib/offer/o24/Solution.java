package com.zpl.lib.offer.o24;

import com.zpl.lib.offer.Constant;

/**
 * 反转链表
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static Constant.ListNode reverseList(Constant.ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Constant.ListNode pre = null;
        Constant.ListNode curr = head;

        while (curr != null) {
            Constant.ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 递归解法
     * @param head
     * @return
     */
    public static Constant.ListNode reverseListRecur(Constant.ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Constant.ListNode revHead = reverseListRecur(head.next);
        Constant.ListNode nextNode = head.next;
        nextNode.next = head;
        head.next = null;
        return revHead;
    }
}

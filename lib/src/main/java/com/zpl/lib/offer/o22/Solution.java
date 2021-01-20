package com.zpl.lib.offer.o22;

import com.zpl.lib.offer.Constant;

/**
 * 链表中倒数第k个结点
 */
public class Solution {

    public static void main(String[] args) {

    }

    public static Constant.ListNode findKthToTail(Constant.ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        Constant.ListNode a = head;
        Constant.ListNode b = head;

        for (int i = 0; i < k - 1; i++) {
            // 如果k大于链表长度
            if (a.next == null) {
                return null;
            }
            a = a.next;
        }

        while (a.next != null) {
            a = a.next;
            b = b.next;
        }
        return b;
    }
}

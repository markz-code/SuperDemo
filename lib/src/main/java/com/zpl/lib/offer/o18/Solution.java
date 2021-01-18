package com.zpl.lib.offer.o18;

import com.zpl.lib.offer.Constant;

/**
 * 删除链表的结点
 */
public class Solution {
    public static void main(String[] args) {

    }

    public static void deleteNode(Constant.ListNode head, Constant.ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return;
        }
        if (toBeDeleted.next != null) {
            // 要删除的不是尾结点
            Constant.ListNode next = toBeDeleted.next;
            toBeDeleted.val = next.val;
            toBeDeleted.next = next.next;
        } else {
            // 要删除的是尾结点
            Constant.ListNode current = head;
            while (current.next != toBeDeleted) {
                current = current.next;
            }
            current.next = null;
        }
    }


    public static Constant.ListNode deleteDuplication_1(Constant.ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            // 有重复的
            while (head != null && head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            // 这里会去除掉最后一个重复
            return deleteDuplication_1(head.next);
        } else {
            head.next = deleteDuplication_1(head.next);
            return head;
        }
    }

    /**
     * 删除链表重复的节点
     *
     * @param pHead ????
     */
    public static Constant.ListNode deleteDuplication_2(Constant.ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        Constant.ListNode preNode = null;
        Constant.ListNode node = pHead;
        while (node != null) {
            Constant.ListNode next = node.next;
            // 删除标记位
            boolean needDeleted = false;
            if (next != null && next.val == node.val) {
                needDeleted = true;
            }
            if (!needDeleted) {
                preNode = node;
                node = node.next;
            } else {
                int value = node.val;
                Constant.ListNode toBeDeleted = node;
                while (toBeDeleted != null && toBeDeleted.val == value) {
                    next = toBeDeleted.next;
                    toBeDeleted = next;
                    // 考虑头指针是否存在
                    if (preNode == null) {
                        pHead = next;
                    } else {
                        preNode.next = next;
                    }
                }
            }
        }
        return pHead;
    }
}

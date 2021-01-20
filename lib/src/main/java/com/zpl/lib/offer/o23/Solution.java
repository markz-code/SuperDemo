package com.zpl.lib.offer.o23;

import com.zpl.lib.offer.Constant;

import java.util.HashSet;

/**
 * 链表中环的入口节点
 */
public class Solution {

    public Constant.ListNode entryNodeOfLoop_set(Constant.ListNode head) {
        HashSet<Constant.ListNode> set = new HashSet<>();
        if(head == null || head.next == null) {
            return null;
        }

        while (head != null) {
            if(!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}

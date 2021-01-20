package com.zpl.lib.offer.o25;

import com.zpl.lib.offer.Constant;

/**
 * 合并两个有序链表
 */
public class Solution {

    private static Constant.ListNode mergeRecur(Constant.ListNode list1, Constant.ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        Constant.ListNode mergeHead = null;
        if (list1.val < list2.val) {
            mergeHead = list1;
            mergeHead.next = mergeRecur(list1.next, list2);
        } else {
            mergeHead = list2;
            mergeHead.next = mergeRecur(list1, list2.next);
        }
        return mergeHead;
    }
    
}

package com.zpl.lib.offer.o35;


/**
 * 复杂链表的复制？？？？？？？
 */
public class Solution {


    public ComplexListNode clone(ComplexListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ComplexListNode current = pHead;
        while (current != null) {
            ComplexListNode clone = new ComplexListNode(current.value);
            clone.next = current.next;
            current.next = clone;
            current = clone.next;
        }

        current = pHead;
        while (current != null) {
            ComplexListNode clone = current.next;
            if (current.random != null) {
                clone.random = current.random.next;
            }
            current = clone.next;
        }

        current = pHead;
        ComplexListNode pCloneHead = pHead.next;
        while (current.next != null) {
            ComplexListNode next = current.next;
            current.next = next.next;
            current = next;
        }
        return pCloneHead;
    }


    public class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode random;

        public ComplexListNode(int value) {
            this.value = value;
        }
    }
}

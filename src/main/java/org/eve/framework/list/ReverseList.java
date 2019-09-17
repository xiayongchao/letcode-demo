package org.eve.framework.list;

import org.eve.framework.Utils;

/**
 * 反转链表
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/6/linked-list/43/
 *
 * @author jc
 * @date 2019/9/17 22:25
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = Utils.convertArrayToListNode(1, 2, 3, 4, 5);
        Utils.printListNode(new ReverseList().reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null, temp;
        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = newHead;
            newHead = temp;
        }
        return newHead;
    }
}

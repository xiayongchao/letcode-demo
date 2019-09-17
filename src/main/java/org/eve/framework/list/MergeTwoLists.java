package org.eve.framework.list;

import org.eve.framework.Utils;

/**
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/6/linked-list/44/
 *
 * @author jc
 * @date 2019/9/17 22:36
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = Utils.convertArrayToListNode(1, 2, 4);
        ListNode l2 = Utils.convertArrayToListNode(1, 3, 4);
        Utils.printListNode(new MergeTwoLists().mergeTwoLists(l1, l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, cur = null;
        while (l1 != null || l2 != null) {
            if (head == null) {
                if (l1 != null && l2 == null) {
                    head = l1;
                    l1 = l1.next;
                } else if (l1 == null && l2 != null) {
                    head = l2;
                    l2 = l2.next;
                } else if (l1.val < l2.val) {
                    head = l1;
                    l1 = l1.next;
                } else {
                    head = l2;
                    l2 = l2.next;
                }
            } else {
                if (cur == null) {
                    cur = head;
                }
                if (l1 != null && l2 == null) {
                    cur.next = l1;
                    l1 = l1.next;
                } else if (l1 == null && l2 != null) {
                    cur.next = l2;
                    l2 = l2.next;
                } else if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
        }
        return head;
    }
}

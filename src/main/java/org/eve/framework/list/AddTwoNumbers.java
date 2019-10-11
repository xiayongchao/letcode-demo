package org.eve.framework.list;

import org.eve.framework.Utils;

/**
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/31/linked-list/82/
 *
 * @author jc
 * @date 2019/9/29 21:42
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Utils.printListNode(new AddTwoNumbers().addTwoNumbers(Utils.convertArrayToListNode(1)
                , Utils.convertArrayToListNode(9, 9)));

        Utils.printListNode(new AddTwoNumbers().addTwoNumbers(Utils.convertArrayToListNode(2, 4, 3)
                , Utils.convertArrayToListNode(5, 6, 4)));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum, jw = 0;
        ListNode l3 = null, temp = null;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + jw;
            } else if (l1 != null) {
                sum = l1.val + jw;
            } else {
                sum = l2.val + jw;
            }
            if (temp == null) {
                temp = new ListNode(sum % 10);
                l3 = temp;
            } else {
                temp.next = new ListNode(sum % 10);
                temp = temp.next;
            }
            jw = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (jw > 0) {
            temp.next = new ListNode(jw);
        }
        return l3;
    }
}

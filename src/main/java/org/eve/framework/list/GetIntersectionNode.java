package org.eve.framework.list;

import org.eve.framework.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/31/linked-list/84/
 *
 * @author jc
 * @date 2019/9/30 13:13
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        System.out.println(new GetIntersectionNode().getIntersectionNode(Utils.convertArrayToListNode(4, 1, 8, 4, 5)
                , Utils.convertArrayToListNode(5, 0, 1, 8, 4, 5)).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null || headB != null) {
            if (set.contains(headA)) {
                return headA;
            }
            set.add(headA);
            if (set.contains(headB)) {
                return headB;
            }
            set.add(headB);
            headA = headA == null ? null : headA.next;
            headB = headB == null ? null : headB.next;
        }
        return null;
    }
}

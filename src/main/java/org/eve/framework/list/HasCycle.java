package org.eve.framework.list;

import java.util.HashMap;

/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/6/linked-list/46/
 *
 * @author jc
 * @date 2019/9/17 23:23
 */
public class HasCycle {
    public static void main(String[] args) {
        System.out.println(new HasCycle().hasCycle(null));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        HashMap<ListNode, Integer> nodeMap = new HashMap<>();
        while (head != null) {
            if (nodeMap.containsKey(head)) {
                return true;
            }
            nodeMap.put(head, null);
            head = head.next;
        }
        return false;
    }
}

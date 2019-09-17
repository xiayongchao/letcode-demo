package org.eve.framework.list;

import org.eve.framework.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除链表的倒数第N个节点
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/6/linked-list/42/
 *
 * @author jc
 * @date 2019/9/17 21:35
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = Utils.convertArrayToListNode(1, 2, 3, 4, 5);
        ListNode listNode = new RemoveNthFromEnd().removeNthFromEnd(head, 2);
        Utils.printListNode(listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        List<ListNode> nodeList = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodeList.add(cur);
            cur = cur.next;
        }
        int i = nodeList.size() - n;
        ListNode next = i + 1 >= nodeList.size() ? null : nodeList.get(i + 1);
        if (i == 0) {
            head = next;
        } else {
            nodeList.get(i - 1).next = next;
        }
        return head;
    }
}

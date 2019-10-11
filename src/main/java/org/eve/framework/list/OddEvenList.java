package org.eve.framework.list;

import org.eve.framework.Utils;

/**
 * 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/31/linked-list/83/
 *
 * @author jc
 * @date 2019/9/29 22:17
 */
public class OddEvenList {
    public static void main(String[] args) {
        Utils.printListNode(new OddEvenList().oddEvenList(Utils.convertArrayToListNode(1, 2, 3, 4, 5)));
        Utils.printListNode(new OddEvenList().oddEvenList(Utils.convertArrayToListNode(2, 1, 3, 5, 6, 4, 7)));
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode oH = null, eH = null, oT = null, eT = null;
        int i = 1;
        while (head != null) {
            if (i % 2 == 1) {
                if (oH == null) {
                    oH = head;
                    oT = oH;
                } else {
                    oT.next = head;
                    oT = oT.next;
                }
            } else {
                if (eH == null) {
                    eH = head;
                    eT = eH;
                } else {
                    eT.next = head;
                    eT = eT.next;
                }
            }
            i++;
            head = head.next;
        }
        if (eT != null) {
            eT.next = null;
        }
        if (oT != null) {
            oT.next = eH;
        }
        return oH;
    }
}

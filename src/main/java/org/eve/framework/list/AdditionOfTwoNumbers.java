package org.eve.framework.list;

import org.eve.framework.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiayc
 * @date 2018/11/8
 * @see <a href="https://leetcode-cn.com/problems/add-two-numbers/">https://leetcode-cn.com/problems/add-two-numbers/</a>
 */
public class AdditionOfTwoNumbers {
    public static void main(String[] args) {
//        ListNode listNode = addTwoNumbers(Utils.convertListToListNode(Arrays.asList(3, 4, 2)), Utils.convertListToListNode(Arrays.asList(4, 6, 5)));
//        ListNode listNode = addTwoNumbers(Utils.convertListToListNode(Arrays.asList(0)), Utils.convertListToListNode(Arrays.asList(4, 6, 5)));
//        ListNode listNode = addTwoNumbers(Utils.convertListToListNode(Arrays.asList(5)), Utils.convertListToListNode(Arrays.asList(4, 6, 5)));
        ListNode listNode = addTwoNumbers(Utils.convertListToListNode(Arrays.asList(5, 3, 5)), Utils.convertListToListNode(Arrays.asList(4, 6, 5)));
        List<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i));
        }
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        int i1, i2, carry = 0, result;
        ListNode headNode = null, tempNode = null;
        while (l1 != null || l2 != null) {
            i1 = l1 == null ? 0 : l1.val;
            i2 = l2 == null ? 0 : l2.val;
            result = i1 + i2 + carry;
            carry = result > 9 ? 1 : 0;
            result = result > 9 ? result - 10 : result;
            if (tempNode == null) {
                tempNode = new ListNode(result);
                headNode = tempNode;
            } else {
                tempNode.next = new ListNode(result);
                tempNode = tempNode.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            tempNode.next = new ListNode(carry);
        }

        return headNode;
    }
}

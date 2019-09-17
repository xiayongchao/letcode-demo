package org.eve.framework.list;

import org.eve.framework.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 * 请判断一个链表是否为回文链表。
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/6/linked-list/45/
 *
 * @author jc
 * @date 2019/9/17 22:49
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome(Utils.convertArrayToListNode(1)));
        System.out.println(new IsPalindrome().isPalindrome(Utils.convertArrayToListNode(1, 2)));
        System.out.println(new IsPalindrome().isPalindrome(Utils.convertArrayToListNode(1, 2, 2, 1)));
        System.out.println(new IsPalindrome().isPalindrome(Utils.convertArrayToListNode(1, 2, 3, 2, 1)));
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<ListNode> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
        for (int i = 0, j = nodeList.size() - 1; i < j; i++, j--) {
            if (nodeList.get(i).val != nodeList.get(j).val) {
                return false;
            }
        }
        return true;
    }
}

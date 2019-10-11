package org.eve.framework.treeandmap;

import org.eve.framework.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/88/
 *
 * @author jc
 * @date 2019/10/4 10:46
 */
public class Connect {

    public static void main(String[] args) {
        new Connect().connect(Utils.buildTreeByGD(1, 2, 3, 4, 5, 6, 7));
    }

    public Node connect(Node root) {
        Queue<Object> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(root);
        int deep, temp = 0;
        Node prev = null, node = root;
        while (!queue.isEmpty()) {
            deep = (int) queue.poll();
            node = (Node) queue.poll();
            if (temp != deep) {
//                System.out.println();
//                System.out.print(deep + " --> ");
                temp = deep;
                prev = node;
            } else if (prev != null) {
                prev.next = node;
                prev = node;
            }
//            System.out.print(node.val);
            if (node == null) {
                continue;
            }
            deep++;
            if (node.left != null) {
                queue.offer(deep);
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(deep);
                queue.offer(node.right);
            }
//            System.out.print(" ");
        }
//        System.out.println();
        return root;
    }
}

package org.eve.framework.treeandmap;

import org.eve.framework.Gsons;
import org.eve.framework.Utils;
import org.eve.framework.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/86/
 *
 * @author jc
 * @date 2019/9/30 15:52
 */
public class ZigzagLevelOrder {
    public static void main(String[] args) {
//        TreeNode root = Utils.buildTree(1, 2, 3, 4, null, null, 5);
        TreeNode root = Utils.buildTree(3, 9, 20, 1, 2, 15, 7);
        List<List<Integer>> lists = new ZigzagLevelOrder().zigzagLevelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(Gsons.getJson(list));
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        zigzagLevelOrder(root, lists);
        return lists;
    }

    private void zigzagLevelOrder(TreeNode root, List<List<Integer>> lists) {
        Queue<Object> queue = new LinkedList<>();
        /*
         * >0:从左到右
         * <0:从右到左
         */
        queue.offer(1);
        queue.offer(root);
        int fx;
        List<Integer> list;
        while (root != null && !queue.isEmpty()) {
            fx = (int) queue.poll();
            root = (TreeNode) queue.poll();
            if (lists.size() < Math.abs(fx)) {
                list = new ArrayList<>();
                list.add(root.val);
                lists.add(list);
            } else {
                list = lists.get(Math.abs(fx) - 1);
                list.add(root.val);
            }
            if (fx > 0) {
                fx = -(++fx);
                if (root.right != null) {
                    queue.offer(fx);
                    queue.offer(root.right);
                }
                if (root.left != null) {
                    queue.offer(fx);
                    queue.offer(root.left);
                }
            } else {
                fx = -(--fx);
                if (root.left != null) {
                    queue.offer(fx);
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(fx);
                    queue.offer(root.right);
                }
            }
        }
    }
}

package org.eve.framework.treeandmap;

import org.eve.framework.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历二叉树
 * 给定一个二叉树，返回它的中序 遍历。
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/85/
 *
 * @author jc
 * @date 2019/9/30 15:35
 */
public class InorderTraversal {
    public static void main(String[] args) {
        new InorderTraversal().inorderTraversal(null);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorderTraversal(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right, list);
        }
    }
}

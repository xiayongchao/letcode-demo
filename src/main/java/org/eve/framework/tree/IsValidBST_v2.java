package org.eve.framework.tree;

import org.eve.framework.Utils;

/**
 * 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * ->   节点的左子树只包含小于当前节点的数。
 * ->   节点的右子树只包含大于当前节点的数。
 * ->   所有左子树和右子树自身必须也是二叉搜索树。
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/7/trees/48/
 *
 * @author jc
 * @date 2019/9/18 0:06
 */
public class IsValidBST_v2 {
    public static void main(String[] args) {
        TreeNode root = Utils.buildTree(5, 1, 4, null, null, 3, 6);
        System.out.println(new IsValidBST_v2().isValidBST(root));
    }

    private class Last {
        Integer val;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //利用深度中序遍历来确认
        return doValidBST(new Last(), root);
    }

    private boolean doValidBST(Last last, TreeNode node) {
        if (node.left != null && !doValidBST(last, node.left)) {
            return false;
        }
        if (last.val != null && last.val >= node.val) {
            return false;
        }
        last.val = node.val;
        if (node.right != null && !doValidBST(last, node.right)) {
            return false;
        }
        return true;
    }
}

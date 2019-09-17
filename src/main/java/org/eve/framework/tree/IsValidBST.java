package org.eve.framework.tree;

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
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return isValidBSTLeft(root.val, root.left) && isValidBSTRight(root.val, root.right);
    }

    public boolean isValidBSTLeft(int pVal, TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && (root.right.val <= root.val || root.right.val >= pVal)) {
            return false;
        }
        return isValidBSTLeft(Math.min(root.val, pVal), root.left)
                && isValidBSTRight(Math.max(root.val, pVal), root.right);
    }

    public boolean isValidBSTRight(int pVal, TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && (root.left.val >= root.val || root.left.val <= pVal)) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return isValidBSTLeft(Math.min(root.val, pVal), root.left)
                && isValidBSTRight(Math.max(root.val, pVal), root.right);
    }
}

package org.eve.framework.tree;

import java.util.ArrayList;
import java.util.List;

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
public class IsValidBST_v1 {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //利用深度中序遍历来确认
        List<Integer> valList = new ArrayList<>();
        doValidBST(valList, root);
        for (int i = 0; i < valList.size() - 1; i++) {
            if (valList.get(i) >= valList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void doValidBST(List<Integer> valList, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            doValidBST(valList, node.left);
        }
        valList.add(node.val);
        if (node.right != null) {
            doValidBST(valList, node.right);
        }
    }
}

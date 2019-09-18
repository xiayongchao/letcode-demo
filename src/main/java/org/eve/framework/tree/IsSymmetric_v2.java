package org.eve.framework.tree;

import org.eve.framework.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/7/trees/49/
 *
 * @author jc
 * @date 2019/9/18 22:27
 */
public class IsSymmetric_v2 {
    public static void main(String[] args) {
        TreeNode root = Utils.buildTree(1, 2, 2, 3, 4, 4, 3);
//        TreeNode root = Utils.buildTree(1, 2, 2, null, 3, null, 3);
        System.out.println(new IsSymmetric_v2().isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        List<List<TreeNode>> nodeListList = new ArrayList<>();
        doIsSymmetric(0, nodeListList, root);
        List<TreeNode> nodeList;
        for (int k = 0; k < nodeListList.size() - 1; k++) {
            nodeList = nodeListList.get(k);
            for (int i = 0, j = nodeList.size() - 1; i < j; i++, j--) {
                if ((nodeList.get(i) == null && nodeList.get(j) != null)
                        || (nodeList.get(i) != null && nodeList.get(j) == null)
                        || (nodeList.get(i) != null && nodeList.get(j) != null
                        && nodeList.get(i).val != nodeList.get(j).val)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void doIsSymmetric(int height, List<List<TreeNode>> nodeListList, TreeNode node) {
        List<TreeNode> nodeList = nodeListList.size() > height ? nodeListList.get(height) : null;
        if (nodeList == null) {
            nodeList = new ArrayList<>();
        }
        nodeList.add(node);
        if (nodeList.size() == 1) {
            nodeListList.add(nodeList);
        }
        if (node == null) {
            return;
        }
        height++;
        doIsSymmetric(height, nodeListList, node.left);
        doIsSymmetric(height, nodeListList, node.right);
    }
}

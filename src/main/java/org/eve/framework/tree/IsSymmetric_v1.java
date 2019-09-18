package org.eve.framework.tree;

import org.eve.framework.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/7/trees/49/
 *
 * @author jc
 * @date 2019/9/18 22:27
 */
public class IsSymmetric_v1 {
    public static void main(String[] args) {
//        TreeNode root = Utils.buildTree(1, 2, 2, 3, 4, 4, 3);
        TreeNode root = Utils.buildTree(1, 2, 2, null, 3, null, 3);
        System.out.println(new IsSymmetric_v1().isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        Map<Integer, List<TreeNode>> nodeMap = new HashMap<>();
        qxubl(1, nodeMap, root);
        for (Map.Entry<Integer, List<TreeNode>> entry : nodeMap.entrySet()) {
            for (int i = 0, j = entry.getValue().size() - 1; i < j; i++, j--) {
                if ((entry.getValue().get(i) == null && entry.getValue().get(j) != null)
                        || (entry.getValue().get(i) != null && entry.getValue().get(j) == null)
                        || (entry.getValue().get(i) != null && entry.getValue().get(j) != null
                        && entry.getValue().get(i).val != entry.getValue().get(j).val)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void qxubl(int height, Map<Integer, List<TreeNode>> nodeMap, TreeNode node) {
        List<TreeNode> nodeList = nodeMap.get(height);
        if (nodeList == null) {
            nodeList = new ArrayList<>();
        }
        nodeList.add(node);
        nodeMap.put(height, nodeList);
        if (node == null) {
            return;
        }
        height++;
        qxubl(height, nodeMap, node.left);
        qxubl(height, nodeMap, node.right);
    }
}

package org.eve.framework.tree;

import org.eve.framework.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jc
 * @date 2019/9/19 0:11
 */
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root = Utils.buildTree(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> listList = new LevelOrder().levelOrder(root);
        System.out.println(listList);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodeListList = new ArrayList<>();
        levelOrder(0, nodeListList, root);
        return nodeListList;
    }

    private void levelOrder(int height, List<List<Integer>> nodeListList, TreeNode node) {
        if (node == null) {
            return;
        }
        List<Integer> nodeList = nodeListList.size() > height ? nodeListList.get(height) : null;
        boolean add = false;
        if (nodeList == null) {
            nodeList = new ArrayList<>();
            add = true;
        }
        nodeList.add(node.val);
        if (add) {
            nodeListList.add(nodeList);
        }
        height++;
        if (node.left != null) {
            levelOrder(height, nodeListList, node.left);
        }
        if (node.right != null) {
            levelOrder(height, nodeListList, node.right);
        }
    }

}

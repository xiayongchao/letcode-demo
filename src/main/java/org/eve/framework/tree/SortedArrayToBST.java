package org.eve.framework.tree;

import org.eve.framework.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/51/
 * <p>
 * 平衡因子（BF Balance Factor）：该结点的左子树的深度减去右子数的深度，则平衡二叉树所有结点的平衡因子可能是 -1 、0、1.
 * 只要二叉树上有一个结点的平衡因子的绝对值大于1，那个该二叉树就不平衡。
 *
 * @author jc
 * @date 2019/9/22 18:32
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        TreeNode treeNode = new SortedArrayToBST().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        Utils.gdyxPrintTreeNode(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        //树高
        Map<TreeNode, Integer> treeHeightMap = new HashMap<>(nums.length);
        for (int num : nums) {
            root = insert(root, num, treeHeightMap);
        }
        return root;
    }

    /**
     * 插入节点
     *
     * @param treeNode
     * @param value
     * @param treeHeightMap
     * @return
     */
    private TreeNode insert(TreeNode treeNode, int value, Map<TreeNode, Integer> treeHeightMap) {
        if (treeNode == null) {
            treeNode = new TreeNode(value);
        } else {

            if (value < treeNode.val) {
                treeNode.left = insert(treeNode.left, value, treeHeightMap);
                if (!isBalance(treeNode, treeHeightMap)) {
                    //如果左子树不平衡
                    if (value < treeNode.left.val) {
                        treeNode = rightRightRotation(treeNode, treeHeightMap);
                    } else {
                        treeNode = leftRightRotation(treeNode, treeHeightMap);
                    }
                }
            } else if (value > treeNode.val) {
                treeNode.right = insert(treeNode.right, value, treeHeightMap);
                if (!isBalance(treeNode, treeHeightMap)) {
                    //如果右子树不平衡
                    if (value > treeNode.right.val) {
                        treeNode = leftLeftRotation(treeNode, treeHeightMap);
                    } else {
                        treeNode = rightLeftRotation(treeNode, treeHeightMap);
                    }
                }
            } else {
                throw new RuntimeException("插入失败");
            }
        }
        increaseHeight(treeNode, treeHeightMap);
        return treeNode;
    }

    private TreeNode leftLeftRotation(TreeNode root, Map<TreeNode, Integer> treeHeightMap) {
        TreeNode rightTreeNode = root.right;
        root.right = rightTreeNode.left;
        rightTreeNode.left = root;
        increaseHeight(rightTreeNode.left, treeHeightMap);
        increaseHeight(rightTreeNode, treeHeightMap);
        return rightTreeNode;
    }

    private TreeNode leftRightRotation(TreeNode treeNode, Map<TreeNode, Integer> treeHeightMap) {
        treeNode.left = leftLeftRotation(treeNode.left, treeHeightMap);
        return rightRightRotation(treeNode, treeHeightMap);
    }

    private TreeNode rightRightRotation(TreeNode root, Map<TreeNode, Integer> treeHeightMap) {
        TreeNode leftTreeNode = root.left;
        root.left = leftTreeNode.right;
        leftTreeNode.right = root;
        increaseHeight(leftTreeNode.right, treeHeightMap);
        increaseHeight(leftTreeNode, treeHeightMap);
        return leftTreeNode;
    }

    private TreeNode rightLeftRotation(TreeNode treeNode, Map<TreeNode, Integer> treeHeightMap) {
        treeNode.right = rightRightRotation(treeNode.right, treeHeightMap);
        return leftLeftRotation(treeNode, treeHeightMap);
    }

    private boolean isBalance(TreeNode treeNode, Map<TreeNode, Integer> treeHeightMap) {
        if (treeNode == null) {
            return true;
        }
        int lh = treeHeightMap.getOrDefault(treeNode.left, 0);
        int rh = treeHeightMap.getOrDefault(treeNode.right, 0);
        return Math.abs(lh - rh) <= 1;
    }

    private void increaseHeight(TreeNode treeNode, Map<TreeNode, Integer> treeHeightMap) {
        if (treeNode == null) {
            return;
        }
        int lh = treeHeightMap.getOrDefault(treeNode.left, 0);
        int rh = treeHeightMap.getOrDefault(treeNode.right, 0);
        treeHeightMap.put(treeNode, Math.max(lh, rh) + 1);
    }
}

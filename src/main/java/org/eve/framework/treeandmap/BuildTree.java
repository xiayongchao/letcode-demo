package org.eve.framework.treeandmap;

import org.eve.framework.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/87/
 *
 * @author jc
 * @date 2019/10/1 10:35
 */
public class BuildTree {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        Map<Integer, Integer> preOrderIndexMap = new HashMap<>(inorder.length);
        for (int i = 0; i < preorder.length; i++) {
            preOrderIndexMap.put(preorder[i], i);
        }
        return buildTree(preorder, 0, inOrderIndexMap, preOrderIndexMap);
    }

    public TreeNode buildTree(int[] preorder, int start, Map<Integer, Integer> inOrderIndexMap, Map<Integer, Integer> preOrderIndexMap) {
        TreeNode treeNode = new TreeNode(preorder[start]);
        Integer mid = inOrderIndexMap.get(start);

        return treeNode;
    }

    public TreeNode buildTree(int[] preorder, int start, int end, Map<Integer, Integer> inOrderIndexMap, Map<Integer, Integer> preOrderIndexMap) {
        TreeNode treeNode = new TreeNode(preorder[start]);
        Integer mid = inOrderIndexMap.get(start);
//        treeNode.left = buildTree(preorder, start + 1, end, inOrderIndexMap);
//        Integer mid = inOrderIndexMap.get(mid - 1);
//        treeNode.right = buildTree(preorder, start + 1, end, inOrderIndexMap);
        return treeNode;
    }
}

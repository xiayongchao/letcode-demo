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
        Utils.printTreeNode(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        Map<TreeNode, Integer> balanceFactorMap = new HashMap<>(nums.length);
        for (int num : nums) {
            if (root == null) {
                root = new TreeNode(num);
                balanceFactorMap.put(root, 0);
                continue;
            }

        }
        return root;
    }
}

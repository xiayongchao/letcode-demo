package org.eve.framework.tree;

/**
 * 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/7/trees/47/
 *
 * @author jc
 * @date 2019/9/17 23:43
 */
public class MaxDepth {
    public static void main(String[] args) {
//        System.out.println(new MaxDepth().maxDepth());
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = maxDepth(root.left) + 1;
        int rh = maxDepth(root.right) + 1;
        return lh > rh ? lh : rh;
    }
}

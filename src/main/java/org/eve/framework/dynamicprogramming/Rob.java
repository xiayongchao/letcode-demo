package org.eve.framework.dynamicprogramming;

import java.util.Arrays;

/**
 * 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/57/
 *
 * @author jc
 * @date 2019/9/21 14:35
 */
public class Rob {
    public static void main(String[] args) {
        //预期14
        System.out.println(new Rob().rob(new int[]{4, 1, 2, 7, 5, 3, 1}));
        System.out.println(new Rob().rob(new int[]{1, 1, 1}));
        System.out.println(new Rob().rob(new int[]{1, 2}));
        System.out.println(new Rob().rob(new int[]{2, 1, 1, 2}));
    }

    public int rob(int[] nums) {
        int max = 0, temp;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        for (int i = 0; i < nums.length; i++) {
            //首先按不同的起始位置偷一遍，选最大的
            if ((temp = rob(i, nums, memo)) > max) {
                max = temp;
            }
        }
        return max;
    }

    private int rob(int start, int[] nums, int[] memo) {
        if (start + 2 >= nums.length) {
            //因为最小的偏移量
            return nums[start];
        }
        if (memo[start] > -1) {
            return memo[start];
        }
        int max = 0, temp;
        for (int offset = 2; offset < nums.length - start; offset++) {
            if ((temp = nums[start] + rob(start + offset, nums, memo)) > max) {
                max = temp;
            }
        }
        memo[start] = max;
        return max;
    }

    /*private int rob(int start, int offset, int[] nums) {
        if (start + offset > nums.length - 1) {
            return nums[start];
        }
        int count = 0;
        for (int i = start; i < nums.length; i = i + offset) {
            count = count + nums[i];
        }
        return count;
    }*/
}

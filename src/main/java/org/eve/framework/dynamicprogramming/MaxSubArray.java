package org.eve.framework.dynamicprogramming;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/56/
 *
 * @author jc
 * @date 2019/9/21 14:10
 */
public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        int max = maxSubArray(0, nums), temp;
        for (int i = 1; i < nums.length; i++) {
            if ((temp = maxSubArray(i, nums)) > max) {
                max = temp;
            }
        }
        return max;
    }

    private int maxSubArray(int start, int[] nums) {
        int max = nums[start], temp = max;
        for (int i = start + 1; i < nums.length; i++) {
            if ((temp = temp + nums[i]) > max) {
                max = temp;
            }
        }
        return max;
    }
}

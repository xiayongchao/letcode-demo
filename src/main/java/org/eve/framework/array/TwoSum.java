package org.eve.framework.array;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/29/
 *
 * @author xiayc
 * @date 2018/7/12
 */
public class TwoSum {
    public static void main(String[] args) {
        Utils.print(twoSum(Utils.newIntArray(2, 7, 11, 15), 9));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}

package org.eve.framework.other;

/**
 * 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/69/
 *
 * @author xiayc
 * @date 2019/9/23
 */
public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(1 ^ 2 ^ 3 ^ 4);
        System.out.println(new MissingNumber().missingNumber(new int[]{3, 0, 1}));
        System.out.println(new MissingNumber().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

    public int missingNumber(int[] nums) {
        int[] buckets = new int[nums.length + 1];
        for (int num : nums) {
            buckets[num] = 1;
        }
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != 1) {
                return i;
            }
        }
        return 0;
    }
}

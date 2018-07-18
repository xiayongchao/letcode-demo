package org.eve.framework.array;

import org.eve.framework.Utils;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/28/
 *
 * @author xiayc
 * @date 2018/7/12
 */
public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[]{0, 0, 1});
        moveZeroes(new int[]{0, 1, 0, 3, 12});

    }

    public static void moveZeroes(int[] nums) {
        Utils.print(nums);
        int k = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                k++;
            } else {
                if (k > 0) {
                    len = len - k;
                    for (int j = i - k; j < len; j++) {
                        nums[j] = nums[j + k];
                    }
                    for (int j = len; j < len + k; j++) {
                        nums[j] = 0;
                    }
                    i = i - k - 1;
                    k = 0;
                }
            }
        }
        Utils.print(nums);
    }
}

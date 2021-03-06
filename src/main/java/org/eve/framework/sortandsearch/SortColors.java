package org.eve.framework.sortandsearch;

import org.eve.framework.Gsons;

/**
 * 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/96/
 *
 * @author jc
 * @date 2019/10/9 23:35
 */
public class SortColors {
    public static void main(String[] args) {
        int[] ints = {2, 0, 2, 1, 1, 0};
        System.out.println("排序前：" + Gsons.getJson(ints));
        new Solution().sortColors(ints);
        System.out.println("排序后：" + Gsons.getJson(ints));
    }

    static class Solution {
        /**
         * 按0、1、2顺序排
         * 使用原地排序
         *
         * @param nums
         */
        public void sortColors(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
        }

        private void quickSort(int[] nums, int l, int r) {
            int i = l, j = r, num = nums[l], temp;

            while (i < j) {
                while (i < j && nums[j] >= num) {
                    j--;
                }
                if (nums[j] < num) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }

                while (i < j && nums[i] <= num) {
                    i++;
                }
                if (nums[i] > num) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
            if (i > l) {
                quickSort(nums, l, i - 1);
            }
            if (j < r) {
                quickSort(nums, i + 1, r);
            }
        }
    }
}
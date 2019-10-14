package org.eve.framework.sortandsearch;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/98/
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class FindKthLargest {
    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(new Solution().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            Set<Integer> set = new HashSet<>(nums.length);
            for (int num : nums) {
                set.add(num);
            }

            nums = new int[set.size()];
            int i = 0;
            for (Integer num : set) {
                nums[i] = num;
                i++;
            }
            Integer largest = findKthLargest(nums, k, 0, nums.length - 1);

            return largest;
        }

        private Integer findKthLargest(int[] nums, int k, int left, int right) {
            int start = left, ended = right, key = nums[left];
            while (start < ended) {

            }

            if (start + k == nums.length) {
                return nums[k];
            }
            if (left < start) {
                findKthLargest(nums, k, left, start - 1);
            }
            return null;
        }
    }
}

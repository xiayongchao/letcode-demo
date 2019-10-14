package org.eve.framework.sortandsearch;

import org.eve.framework.Gsons;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/100/
 *
 * @author jc
 * @date 2019/10/14 23:12
 */
public class SearchRange {
    public static void main(String[] args) {
        System.out.println(Gsons.getJson(new Solution().searchRange(new int[]{1}, 1)));
        System.out.println(Gsons.getJson(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Gsons.getJson(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    }

    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] pos = new int[]{-1, -1};
            int start = 0, ended = nums.length - 1, mid;
            while (start <= ended) {
                mid = start + (ended - start) / 2;
                if (nums[mid] > target) {
                    ended = mid - 1;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    pos[0] = pos[1] = mid;
                    for (int i = mid - 1; i >= 0; i--) {
                        if (nums[i] == target) {
                            pos[0] = i;
                        } else {
                            break;
                        }
                    }
                    for (int i = mid + 1; i < nums.length; i++) {
                        if (nums[i] == target) {
                            pos[1] = i;
                        } else {
                            break;
                        }
                    }
                    break;
                }
            }
            return pos;
        }
    }
}

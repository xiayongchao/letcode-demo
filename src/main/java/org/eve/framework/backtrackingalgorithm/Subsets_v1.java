package org.eve.framework.backtrackingalgorithm;

import org.eve.framework.Gsons;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/94/
 *
 * @author jc
 * @date 2019/10/11 0:23
 */
public class Subsets_v1 {
    public static void main(String[] args) {
        /**
         * 输入: nums = [1,2,3]
         * 输出:
         * [
         *   [3],
         *   [1],
         *   [2],
         *   [1,2,3],
         *   [1,3],
         *   [2,3],
         *   [1,2],
         *   []
         * ]
         * */
        for (List<Integer> subset : new Solution().subsets(new int[]{1, 2, 3})) {
            System.out.println(Gsons.getJson(subset));
        }
    }

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> sets = new ArrayList<>();
            for (int i = 0; i <= nums.length; i++) {
                subsets(sets, i, nums, new HashSet<>(i));
            }
            return sets;
        }

        private void subsets(List<List<Integer>> sets, int eleNum, int[] nums, Set<Integer> subs) {
            if (eleNum == 0) {
                sets.add(new ArrayList<>(0));
                return;
            }
            if (eleNum == nums.length) {
                List<Integer> list = new ArrayList<>(eleNum);
                for (int num : nums) {
                    list.add(num);
                }
                sets.add(list);
                return;
            }
            if (eleNum == subs.size()) {
                List<Integer> list = new ArrayList<>(eleNum);
                for (int sub : subs) {
                    list.add(sub);
                }
                sets.add(list);
                return;
            }
            for (int num : nums) {
                if (subs.contains(num)) {
                    return;
                }
                subs.add(num);
                subsets(sets, eleNum, nums, subs);
                subs.remove(num);
            }
        }
    }
}

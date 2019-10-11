package org.eve.framework.backtrackingalgorithm;

import org.eve.framework.Gsons;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/93/
 *
 * @author jc
 * @date 2019/10/9 22:36
 */
public class Permute {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().permute(new int[]{1, 2, 3});
        for (List<Integer> list : lists) {
            System.out.println(Gsons.getJson(list));
        }
    }

    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            int length = 1;
            for (int i = 1; i <= nums.length; i++) {
                length = length * i;
            }

            List<List<Integer>> permutes = new ArrayList<>(length);

            permute(permutes, nums, new int[nums.length], 0, new HashSet<>());
            return permutes;
        }

        private void permute(List<List<Integer>> permutes, int[] nums, int[] ints, int pos, Set<Integer> set) {
            if (ints.length == pos) {
                List<Integer> list = new ArrayList<>(ints.length);
                for (int i : ints) {
                    list.add(i);
                }
                permutes.add(list);
            } else {
                for (int num : nums) {
                    if (!set.contains(num)) {
                        ints[pos] = num;
                        set.add(num);
                        permute(permutes, nums, ints, pos + 1, set);
                        set.remove(num);
                    }
                }
            }
        }
    }
}

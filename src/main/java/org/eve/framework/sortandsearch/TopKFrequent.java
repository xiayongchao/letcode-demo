package org.eve.framework.sortandsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/97/
 *
 * @author jc
 * @date 2019/10/12 21:13
 */
public class TopKFrequent {

    public static void main(String[] args) {
        System.out.println(new Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        System.out.println(new Solution().topKFrequent(new int[]{1}, 1));
    }

    static class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> frequentMap = new HashMap<>();
            for (int num : nums) {
                frequentMap.put(num, frequentMap.getOrDefault(num, 0) + 1);
            }

            nums = new int[frequentMap.size()];
            int[] frequents = new int[frequentMap.size()];
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : frequentMap.entrySet()) {
                nums[i] = entry.getKey();
                frequents[i] = entry.getValue();
                i++;
            }

            List<Integer> topKList = new ArrayList<>();
            topKQuickSort(nums, frequents, k, 0, nums.length - 1, topKList);
            return topKList;
        }

        private void topKQuickSort(int[] nums, int[] frequents, int k, int left, int right, List<Integer> topKList) {
            int start = left, ended = right, key = frequents[left], tempNum, tempFrequent;

            while (start < ended) {
                while (start < ended && frequents[ended] >= key) {
                    ended--;
                }
                if (frequents[ended] < key) {
                    tempNum = nums[start];
                    nums[start] = nums[ended];
                    nums[ended] = tempNum;

                    tempFrequent = frequents[start];
                    frequents[start] = frequents[ended];
                    frequents[ended] = tempFrequent;
                }

                while (start < ended && frequents[start] <= key) {
                    start++;
                }

                if (frequents[start] > key) {
                    tempNum = nums[start];
                    nums[start] = nums[ended];
                    nums[ended] = tempNum;

                    tempFrequent = frequents[start];
                    frequents[start] = frequents[ended];
                    frequents[ended] = tempFrequent;
                }
            }

            if (nums.length == k + start) {
                for (int i = start; i < nums.length; i++) {
                    topKList.add(nums[i]);
                }
                return;
            }
            if (left < start && nums.length - k < start) {
                topKQuickSort(nums, frequents, k, left, start - 1, topKList);
            }
            if (ended < right && nums.length - k > ended) {
                topKQuickSort(nums, frequents, k, ended + 1, right, topKList);
            }
        }
    }
}

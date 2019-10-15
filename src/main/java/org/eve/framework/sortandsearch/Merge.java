package org.eve.framework.sortandsearch;

import org.eve.framework.Gsons;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/101/
 *
 * @author jc
 * @date 2019/10/15 0:21
 */
public class Merge {
    public static void main(String[] args) {
        int[][] merge = new Solution().merge(new int[][]{
                {4, 5}, {2, 4}, {4, 6}, {3, 4}, {0, 0}, {1, 1}, {3, 5}, {2, 2}
        });
        for (int[] ints : merge) {
            System.out.println(Gsons.getJson(ints));
        }
        System.out.println("--------------------------");
        /*merge = new Solution().merge(new int[][]{

        });
        for (int[] ints : merge) {
            System.out.println(Gsons.getJson(ints));
        }
        System.out.println("--------------------------");
        merge = new Solution().merge(new int[][]{
                {1, 4}, {0, 0}
        });
        for (int[] ints : merge) {
            System.out.println(Gsons.getJson(ints));
        }
        System.out.println("--------------------------");
        merge = new Solution().merge(new int[][]{
                {1, 4}, {0, 1}
        });
        for (int[] ints : merge) {
            System.out.println(Gsons.getJson(ints));
        }
        System.out.println("--------------------------");
        merge = new Solution().merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        });
        for (int[] ints : merge) {
            System.out.println(Gsons.getJson(ints));
        }
        System.out.println("--------------------------");

        merge = new Solution().merge(new int[][]{
                {1, 4}, {4, 5}
        });
        for (int[] ints : merge) {
            System.out.println(Gsons.getJson(ints));
        }*/
    }

    static class Solution {
        private void quickSort(int[][] intervals, int left, int right) {
            int start = left, ended = right, key = intervals[left][0];
            int[] temp;
            while (start < ended) {
                while (start < ended && intervals[ended][0] >= key) {
                    ended--;
                }
                if (intervals[ended][0] < key) {
                    temp = intervals[start];
                    intervals[start] = intervals[ended];
                    intervals[ended] = temp;
                }
                while (start < ended && intervals[start][0] <= key) {
                    start++;
                }
                if (intervals[start][0] > key) {
                    temp = intervals[start];
                    intervals[start] = intervals[ended];
                    intervals[ended] = temp;
                }
            }

            if (left < start) {
                quickSort(intervals, left, start - 1);
            }
            if (ended < right) {
                quickSort(intervals, ended + 1, right);
            }
        }

        public int[][] merge(int[][] intervals) {
            if (intervals.length > 1) {
                quickSort(intervals, 0, intervals.length - 1);
            }
            List<int[]> mergeList = new ArrayList<>(intervals.length);
            int[] merge = null;
            for (int[] interval : intervals) {
                if (merge == null) {
                    merge = interval;
                } else {
                    if (merge[1] >= interval[0]) {
                        if (merge[0] > interval[0]) {
                            merge[0] = interval[0];
                        }
                        if (interval[1] > merge[1]) {
                            merge[1] = interval[1];
                        }
                    } else {
                        mergeList.add(merge);
                        merge = interval;
                    }
                }
            }
            if (merge != null) {
                mergeList.add(merge);
            }
            int[][] merges = new int[mergeList.size()][2];
            for (int i = 0; i < mergeList.size(); i++) {
                merges[i] = mergeList.get(i);
            }
            return merges;
        }
    }
}

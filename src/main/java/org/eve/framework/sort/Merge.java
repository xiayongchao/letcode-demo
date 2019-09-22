package org.eve.framework.sort;

/**
 * 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * https://leetcode-cn.com/explore/featured/card/top-interview-questions-easy/8/sorting-and-searching/52/
 *
 * @author jc
 * @date 2019/9/19 22:37
 */
public class Merge {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        new Merge().merge(nums1, 3, new int[]{2, 5, 6}, 3);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums0 = new int[m];
        for (int i = 0; i < m; i++) {
            nums0[i] = nums1[i];
        }
        int mi = 0, ni = 0, j = 0;
        while (mi < m || ni < n) {
            if (mi < m && ni >= n) {
                nums1[j] = nums0[mi];
                mi++;
            } else if (mi >= m && ni < n) {
                nums1[j] = nums2[ni];
                ni++;
            } else if (nums0[mi] < nums2[ni]) {
                nums1[j] = nums0[mi];
                mi++;
            } else {
                nums1[j] = nums2[ni];
                ni++;
            }

            j++;
        }
    }
}

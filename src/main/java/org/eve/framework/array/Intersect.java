package org.eve.framework.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个数组，写一个方法来计算它们的交集。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/26/
 *
 * @author xiayc
 * @date 2018/7/12
 */
public class Intersect {
    public static void main(String[] args) {
        int[] intersect = intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int i : intersect) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            for (int i1 : nums2) {
                if (i == i1) {
                    list.add(i);
                    break;
                }
            }
        }
        int[] intersect = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            intersect[i] = list.get(i);
        }
        return intersect;
    }
}

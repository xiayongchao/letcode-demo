package org.eve.framework.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<Integer, Integer> map1 = new HashMap<>(nums1.length);
        for (int i : nums1) {
            if (map1.containsKey(i)) {
                map1.put(i, map1.get(i) + 1);
            } else {
                map1.put(i, 1);
            }
        }
        Map<Integer, Integer> map2 = new HashMap<>(nums2.length);
        for (int i : nums2) {
            if (map2.containsKey(i)) {
                map2.put(i, map2.get(i) + 1);
            } else {
                map2.put(i, 1);
            }
        }
        List<Integer> result = new ArrayList<>(nums1.length > nums2.length ? nums2.length : nums1.length);
        int times1, times2, times;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (!map2.containsKey(entry.getKey())) {
                continue;
            }
            times1 = map2.get(entry.getKey());
            times2 = entry.getValue();
            for (int i = 0; i < (times1 < times2 ? times1 : times2); i++) {
                result.add(entry.getKey());
            }
        }
        int[] intersect = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intersect[i] = result.get(i);
        }
        return intersect;
    }

    @Deprecated
    public static int[] intersectX(int[] nums1, int[] nums2) {
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

package org.eve.framework.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jc
 * @date 2019/9/22 23:15
 */
public class ThreeSum {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        list = new ArrayList<>(3);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        lists.add(list);
                    }
                }
            }
        }
        return lists;
    }
}

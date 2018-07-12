package org.eve.framework.array;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 输入:[1,2,3,4,5,6,7] 和 k = 3
 * 输出:[5,6,7,1,2,3,4]
 *
 * @author xiayc
 * @date 2018/7/12
 */
public class Rotate {
    public static void main(String[] args) {
        rotate(new int[]{1, 2}, 1);
        rotate(new int[]{1, 2, 3, 4}, 2);
        rotate(new int[]{1, 2, 3, 4, 5, 6}, 3);
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    public static void rotate(int[] nums, int k) {
        print(nums);
        if (nums == null || nums.length <= 1) {
            return;
        }
        if (k < 0) {
            return;
        }
        int length = nums.length;
        k = k % length;
        if (k == 0) {
            return;
        }

        int newIndex, i = 0, j = 0, m = 0, src = nums[i], tgt;
        boolean flag = length % k == 0 || length % (length - k) == 0;
        while (j < length) {
            j++;
            newIndex = (i + k) % length;
            tgt = nums[newIndex];
            nums[newIndex] = src;

            if (flag && m == newIndex) {
                m++;
                newIndex = m;
                src = nums[newIndex];
            } else {
                src = tgt;
            }
            i = newIndex;
        }
        print(nums);
        System.out.println("---------------------------");
    }

    public static void print(int[] nums) {
        if (nums == null) {
            return;
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
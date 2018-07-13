package org.eve.framework.array;

/**
 * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/27/
 *
 * @author xiayc
 * @date 2018/7/12
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] ints = plusOne(new int[]{1, 2, 3});
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println();
        ints = plusOne(new int[]{9, 9, 9, 9});
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println();
    }

    public static int[] plusOne(int[] digits) {
        int num;
        for (int i = digits.length - 1; i >= 0; i--) {
            num = digits[i] + 1;
            if (num < 10) {
                digits[i] = num;
                return digits;
            }
            digits[i] = num % 10;
        }
        int[] nums = new int[digits.length + 1];
        nums[0] = 1;
        for (int j = 0; j < digits.length; j++) {
            nums[j + 1] = digits[j];
        }
        return nums;
    }
}

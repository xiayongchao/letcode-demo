package org.eve.framework.designproblem;

/**
 * @author jc
 * @date 2019/9/22 9:49
 */
public class ShuffleAnArray {

    public static void main(String[] args) {
        Solution obj = new Solution(new int[]{1, 2, 3});
        int[] param_1 = obj.reset();
        for (int i : param_1) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] param_2 = obj.shuffle();
        for (int i : param_2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static class Solution {
        private int[] originalNums;

        public Solution(int[] nums) {
            this.originalNums = nums;
        }

        public int[] reset() {
            return originalNums;
        }

        public int[] shuffle() {
            int[] shuffleNums = new int[originalNums.length];

            return shuffleNums;
        }
    }
}

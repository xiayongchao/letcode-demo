package org.eve.framework.sortandsearch;

/**
 * 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/103/
 *
 * @author jc
 * @date 2019/10/15 23:14
 */
public class SearchMatrix {
    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{
                {1, 4},
                {2, 5}
        }, 4));

        System.out.println(new Solution().searchMatrix(new int[][]{
                {-1, 3}
        }, 3));

        System.out.println(new Solution().searchMatrix(new int[][]{
        }, 0));

        System.out.println(new Solution().searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 5));

        System.out.println(new Solution().searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 20));
    }

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int len = Math.min(matrix.length, matrix.length == 0 ? 0 : matrix[0].length);
            int diagonal = -1;
            for (int i = 0; i < len; i++) {
                if (matrix[i][i] == target) {
                    return true;
                }
                diagonal = i;
                if (matrix[i][i] > target) {
                    break;
                }
            }
            if (diagonal == -1) {
                return false;
            }

            for (int i = (matrix[0].length - 1 >= diagonal ? 0 : diagonal); i < matrix.length; i++) {
                for (int j = (i < diagonal ? diagonal : 0); j < matrix[i].length; j++) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}

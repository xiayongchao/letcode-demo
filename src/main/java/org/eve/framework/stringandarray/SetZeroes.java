package org.eve.framework.stringandarray;

/**
 * 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/76/
 *
 * @author jc
 * @date 2019/9/24 23:54
 */
public class SetZeroes {
    public static void main(String[] args) {
        new SetZeroes().setZeroes(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        });

        System.out.println("-------------------------");
        new SetZeroes().setZeroes(new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        });
    }

    public void setZeroes(int[][] matrix) {
        int[] xMemo = new int[matrix.length];
        for (int i = 0; i < xMemo.length; i++) {
            xMemo[i] = -1;
        }
        int[] yMemo = new int[matrix[0].length];
        for (int i = 0; i < yMemo.length; i++) {
            yMemo[i] = -1;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    xMemo[i] = 0;
                    yMemo[j] = 0;
                }
            }
        }

        for (int i = 0; i < xMemo.length; i++) {
            if (xMemo[i] == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < yMemo.length; i++) {
            if (yMemo[i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    private void setZero(int x, int y, int[][] matrix, int[] xMemo, int[] yMemo) {
        if (xMemo[x] == -1) {
            for (int i = 0; i < matrix[x].length; i++) {
                matrix[x][i] = 0;
            }
            xMemo[x] = 0;
        }
        if (yMemo[y] == -1) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][y] = 0;
            }
            yMemo[y] = 0;
        }
    }
}

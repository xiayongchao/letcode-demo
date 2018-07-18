package org.eve.framework.array;

import org.eve.framework.Utils;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 说明：你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/31/
 *
 * @author xiayc
 * @date 2018/7/17
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = Utils.jsonToObject("[\n" +
                "  [1,2,3],\n" +
                "  [4,5,6],\n" +
                "  [7,8,9]\n" +
                "]", int[][].class);
        Utils.print(matrix);
        rotate(matrix);
        Utils.print(matrix);
        System.out.println("------------------------------");
        matrix = Utils.jsonToObject("[\n" +
                "  [ 5, 1, 9,11],\n" +
                "  [ 2, 4, 8,10],\n" +
                "  [13, 3, 6, 7],\n" +
                "  [15,14,12,16]\n" +
                "]", int[][].class);
        Utils.print(matrix);
        rotate(matrix);
        Utils.print(matrix);

    }

    /**
     * 1 2
     * 3 4
     * <p>
     * 3 1
     * 4 2
     * <p>
     * 3 * 3
     * 0,0 -> 0,3
     * 0,1 -> 1,3
     * 0,2 - > 2,3
     * <p>
     * 1,0 - > 0,1
     * 1,1 - > 1,1
     * 1,2 - > 2,2
     * <p>
     * i,j - > j,L-j
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length - 1, tmpI, thisX, thisY, nextX, nextY, tmp, temp;
        for (int j = 0; j < matrix.length / 2 + 1; j++) {
            thisY = j;
            for (int i = j; i < matrix.length - 1 - j; i++) {
                thisX = i;
                tmpI = thisY;
                nextY = n - thisX;
                nextX = tmpI;
                tmp = matrix[thisX][thisY];
                while (thisX != nextX || thisY != nextY) {
                    temp = matrix[nextX][nextY];
                    matrix[nextX][nextY] = tmp;
                    tmp = temp;
                    tmpI = nextY;
                    nextY = n - nextX;
                    nextX = tmpI;
                }
                matrix[thisX][thisY] = tmp;
            }
        }
    }
}

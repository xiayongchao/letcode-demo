package org.eve.framework.other;

/**
 * 汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/65/
 *
 * @author jc
 * @date 2019/9/24 0:48
 */
public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance(1, 4));
    }

    public int hammingDistance(int x, int y) {
        int z = x ^ y, count = 0, divisor, remainder;
        do {
            divisor = z / 2;
            remainder = z % 2;
            if (remainder == 1) {
                count++;
            }
            z = divisor;
        } while (z > 0);
        return count;
    }
}

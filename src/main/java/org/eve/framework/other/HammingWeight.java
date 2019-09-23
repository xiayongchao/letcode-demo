package org.eve.framework.other;

/**
 * 位1的个数
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/64/
 *
 * @author jc
 * @date 2019/9/24 1:27
 */
public class HammingWeight {
    public static void main(String[] args) {
        //输出：3
        System.out.println(new HammingWeight().hammingWeight(0b00000000000000000000000000001011));
        //输出：1
        System.out.println(new HammingWeight().hammingWeight(0b00000000000000000000000010000000));
        //输出：31
        System.out.println(new HammingWeight().hammingWeight(0b11111111111111111111111111111101));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}

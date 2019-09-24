package org.eve.framework.other;

/**
 * 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/66/
 * <p>
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 *
 * @author jc
 * @date 2019/9/24 1:33
 */
public class ReverseBits {
    public static void main(String[] args) {
        /*
        输入: 00000010100101000001111010011100
        输出: 00111001011110000010100101000000
        解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
        因此返回 964176192，其二进制表示形式为
        00111001 01111000 00101001 01000000。
        00111001 01111000 00101001 01000000
                 1928352384
        */
        System.out.println(0b00111001011110000010100101000000);
        System.out.println(new ReverseBits().reverseBits(0b00000010100101000001111010011100));
        System.out.println("-------------------------------------");
        System.out.println(0b11111111111111111111111111111101);
        System.out.println(new ReverseBits().reverseBits(0b11111111111111111111111111111101));
        System.out.println("-------------------------------------");
        /*
        输入：10010110111001001101001111110101
        输出：3493124245 (11010000001101001101100010010101)
        预期：2949326697 (10101111110010110010011101101001)
         */
        System.out.println(0b10010110111001001101001111110101);
        System.out.println(0b10101111110010110010011101101001);
        System.out.println(new ReverseBits().reverseBits(0b10010110111001001101001111110101));
        System.out.println("-------------------------------------");
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int divisor, remainder, x = 30, result = 0;
        boolean f = false;
        if (n < 0) {
            n = -n;
//            n = ~(n - 1);
            System.out.println(n);
            f = true;
//            result--;
        }
        do {
            divisor = n / 2;
            remainder = n % 2;
            if (remainder != 0) {
                result = (2 << x) + result;
            }
            System.out.print(remainder);
            x--;
            n = divisor;
        } while (n > 0);
        for (int i = 0; i <= x; i++) {
            System.out.print(0);
        }
        System.out.println();
/*
        if (f) {
            return (~(-result)) + 1;
        }
*/
        return result;
    }
}

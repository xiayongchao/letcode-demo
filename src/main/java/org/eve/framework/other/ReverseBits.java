package org.eve.framework.other;

/**
 * @author jc
 * @date 2019/9/24 1:33
 */
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(0b11111111111111111111111111111101));
//        System.out.println(new ReverseBits().reverseBits(0b00000010100101000001111010011100));
//                                                          0b00111001011110000010100101000000
//        System.out.println(new ReverseBits().reverseBits(0b11111111111111111111111111111101));
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int divisor, remainder, x = 30, result = 0;
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
        System.out.println();
        return result;
    }
}

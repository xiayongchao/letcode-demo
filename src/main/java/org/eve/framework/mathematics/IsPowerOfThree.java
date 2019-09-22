package org.eve.framework.mathematics;

/**
 * @author jc
 * @date 2019/9/22 14:32
 */
public class IsPowerOfThree {
    public static void main(String[] args) {
        System.out.println(new IsPowerOfThree().isPowerOfThree(27));
        System.out.println(new IsPowerOfThree().isPowerOfThree(0));
        System.out.println(new IsPowerOfThree().isPowerOfThree(9));
        System.out.println(new IsPowerOfThree().isPowerOfThree(45));
    }

    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        if (n % 3 != 0) {
            return false;
        }
        if ((n = n / 3) == 3) {
            return true;
        }
        return isPowerOfThree(n);
    }
}

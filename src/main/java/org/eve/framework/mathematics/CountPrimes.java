package org.eve.framework.mathematics;

/**
 * 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/25/math/61/
 *
 * @author jc
 * @date 2019/9/22 14:24
 */
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(10));
    }

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrimes(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

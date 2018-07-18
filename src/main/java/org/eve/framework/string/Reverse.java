package org.eve.framework.string;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 * @author xiayc
 * @date 2018/7/17
 * @see <a href="https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/33/">https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/33/</a>
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf("9646324351"));
        /*System.out.println(Math.pow(-2, 31));
        System.out.println(Math.pow(2, 31) - 1);
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
      */
/*        if (i > Math.pow(2, 31) - 1 || i < Math.pow(-2, 31)) {
            return 0;
        }*/

    }

    public static int reverse(int x) {
        String num = String.valueOf(x);
        boolean negative = num.startsWith("-");
        char[] chars = num.toCharArray();
        int lp = negative ? 1 : 0, rp = chars.length;
        for (int i = chars.length - 1; i >= lp; i--) {
            if (chars[i] != '0') {
                rp = i;
                break;
            }
        }
        if (rp == chars.length) {
            return 0;
        }

        char nums[] = new char[negative ? rp - lp + 2 : rp - lp + 1];
        for (int i = lp, j = nums.length - 1; i <= rp; i++, j--) {
            nums[j] = chars[i];
        }
        if (negative) {
            nums[0] = '-';
        }
        String s = new String(nums);
        int i;
        try {
            i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            i = 0;
        }
        return i;
    }
}

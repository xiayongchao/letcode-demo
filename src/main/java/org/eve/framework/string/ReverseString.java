package org.eve.framework.string;

/**
 * 请编写一个函数，其功能是将输入的字符串反转过来。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/32/
 *
 * @author xiayc
 * @date 2018/7/17
 */
public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }

    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int lp = 0, rp = chars.length - 1;
        char temp;
        while (lp < rp) {
            temp = chars[lp];
            chars[lp] = chars[rp];
            chars[rp] = temp;
            lp++;
            rp--;
        }
        return new String(chars);
    }
}

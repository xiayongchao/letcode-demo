package org.eve.framework.stringandarray;

/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/79/
 *
 * @author jc
 * @date 2019/9/26 0:44
 */
public class LongestPalindrome {
    /*
    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。
    */
    /*
    输入: "cbbd"
    输出: "bb"
    */
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
        System.out.println(new LongestPalindrome().longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length;
        String longest = null;
        boolean movLeft = false;
        while (left < right) {
            if (chars[left] != chars[right]) {
                if (movLeft) {
                    left++;
                } else {
                    right--;
                }
                continue;
            }

            movLeft = !movLeft;
        }
        return longest;
    }
}

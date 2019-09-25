package org.eve.framework.stringandarray;

import java.util.HashMap;
import java.util.Map;

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
        Map<Character, Integer> map = new HashMap<>(chars.length);
        int start = 0, max = 0, temp = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars.length - start < max) {
                break;
            }
            if (temp == 0 && i + 1 < chars.length && chars[i] == chars[i + 1]) {
                continue;
            }
            if (map.getOrDefault(chars[i], -1) < start) {
                temp++;
            } else {
                if (temp > max) {
                    max = temp;
                }
                start = map.get(chars[i]) + 1;
                temp = i - start + 1;
            }
            map.put(chars[i], i);
        }
        if (temp > max) {
            max = temp;
        }
        return max;
    }
}

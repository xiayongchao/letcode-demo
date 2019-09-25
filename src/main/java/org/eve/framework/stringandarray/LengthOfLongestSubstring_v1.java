package org.eve.framework.stringandarray;

import java.util.HashMap;
import java.util.Map;

/**
 * %22
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/78/
 *
 * @author jc
 * @date 2019/9/25 22:44
 */
public class LengthOfLongestSubstring_v1 {
    public static void main(String[] args) {
        //2
        System.out.println(new LengthOfLongestSubstring_v1().lengthOfLongestSubstring("abba"));
        //5
        System.out.println(new LengthOfLongestSubstring_v1().lengthOfLongestSubstring("anviaj"));
        //3
        System.out.println(new LengthOfLongestSubstring_v1().lengthOfLongestSubstring("dvdf"));
        //3
        System.out.println(new LengthOfLongestSubstring_v1().lengthOfLongestSubstring("abcabcbb"));
        //1
        System.out.println(new LengthOfLongestSubstring_v1().lengthOfLongestSubstring("bbbbb"));
        //3
        System.out.println(new LengthOfLongestSubstring_v1().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int start = 0, max = 0, temp = 0;
        boolean init = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars.length - start < max) {
                break;
            }
            if (init && i + 1 < chars.length && chars[i] == chars[i + 1]) {
                continue;
            }
            init = false;
            if (!Boolean.TRUE.equals(map.get(chars[i]))) {
                map.put(chars[i], true);
                temp++;
            } else {
                if (temp > max) {
                    max = temp;
                }
                temp = 0;
                i = start;
                map.clear();
                start++;
                init = true;
            }
        }
        if (temp > max) {
            max = temp;
        }
        return max;
    }
}

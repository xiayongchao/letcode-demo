package org.eve.framework.stringandarray;

import java.util.HashMap;
import java.util.Map;

/**
 * %88
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/78/
 *
 * @author jc
 * @date 2019/9/25 22:44
 */
public class LengthOfLongestSubstring_v3 {
    public static void main(String[] args) {
        //4
        System.out.println(new LengthOfLongestSubstring_v3().lengthOfLongestSubstring("jbpnbwwd"));
        //2
        System.out.println(new LengthOfLongestSubstring_v3().lengthOfLongestSubstring("abba"));
        //5
        System.out.println(new LengthOfLongestSubstring_v3().lengthOfLongestSubstring("anviaj"));
        //3
        System.out.println(new LengthOfLongestSubstring_v3().lengthOfLongestSubstring("dvdf"));
        //3
        System.out.println(new LengthOfLongestSubstring_v3().lengthOfLongestSubstring("abcabcbb"));
        //1
        System.out.println(new LengthOfLongestSubstring_v3().lengthOfLongestSubstring("bbbbb"));
        //3
        System.out.println(new LengthOfLongestSubstring_v3().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
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

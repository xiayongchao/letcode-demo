package org.eve.framework.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * @author xiayc
 * @date 2018/7/17
 * @see <a href=https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/34/>https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/34/</a>
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar(""));
    }

    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.containsKey(chars[i]) ? null : i);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                return entry.getValue();
            }
        }
        return -1;
    }
}

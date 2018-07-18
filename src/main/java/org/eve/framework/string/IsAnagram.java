package org.eve.framework.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiayc
 * @date 2018/7/17
 */
public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] schars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(schars.length);
        for (int i = 0; i < schars.length; i++) {
            map.put(schars[i], map.getOrDefault(schars[i], 0) + 1);
        }
        char[] tchars = t.toCharArray();
        int times;
        for (int i = 0; i < tchars.length; i++) {
            if (!map.containsKey(tchars[i])) {
                return false;
            }
            times = map.get(tchars[i]);
            times--;
            if (times == 0) {
                map.remove(tchars[i]);
            } else {
                map.put(tchars[i], times);
            }
        }
        return map.size() == 0;
    }
}

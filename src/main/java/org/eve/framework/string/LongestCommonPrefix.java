package org.eve.framework.string;

/**
 * @author xiayc
 * @date 2018/7/18
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{}));
        System.out.println(longestCommonPrefix(new String[]{"flower"}));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int len = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < len) {
                len = strs[i].length();
            }
        }
        StringBuilder sb = new StringBuilder(len);
        char tmp;
        for (int i = 0; i < len; i++) {
            tmp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (tmp != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(tmp);
        }
        return sb.toString();
    }
}

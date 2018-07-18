package org.eve.framework.string;

/**
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * @author xiayc
 * @date 2018/7/18
 * @see <a href="https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/38/">https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/38/</a>
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("hello", ""));
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
    }

    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}

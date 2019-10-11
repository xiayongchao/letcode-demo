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
        System.out.println(Manacher("ccc"));
        System.out.println(new LongestPalindrome().longestPalindrome("ccc"));
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
        System.out.println(new LongestPalindrome().longestPalindrome("cbbd"));
    }

    public static String Manacher(String s) {
        // Insert '#'
        String t = "$#";
        for (int i = 0; i < s.length(); ++i) {
            t += s.charAt(i);
            t += "#";
        }
        t += "@";
        // Process t
        int[] p = new int[t.length()];
        int mx = 0, id = 0, resLen = 0, resCenter = 0;
        for (int i = 1; i < t.length() - 1; ++i) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (((i - p[i]) >= 0) && ((i + p[i]) < t.length() - 1) && (t.charAt(i + p[i]) == t.charAt(i - p[i]))) {
                ++p[i];
            }
            if (mx < i + p[i]) {
                mx = i + p[i];
                id = i;
            }
            if (resLen < p[i]) {
                resLen = p[i];
                resCenter = i;
            }
        }
        return s.substring((resCenter - resLen) / 2, (resCenter - resLen) / 2 + resLen - 1);
    }


    /**
     * 使用马拉车算法
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        s = preProcessing(s);
        char[] chars = s.toCharArray();
        int[] P = new int[chars.length];
        int L = 0, R = 0, M = 0, max = 0;
        int l, r;
        for (int i = 1; i < chars.length; i++) {
            if (i >= R) {
                l = r = i;
                while (l >= 1 && r < chars.length && chars[l] == chars[r]) {
                    l--;
                    r++;
                }
                if (l <= 1 || r >= chars.length || chars[l] != chars[r]) {
                    l++;
                    r--;
                }
                P[i] = r - l + 1;
                if (P[i] > max) {
                    max = P[i];
                    R = r;
                    L = l;
                    M = i;
                }
            } else {
                P[i] = Math.min(P[M * 2 - i], R - i);
            }
        }
        StringBuilder longest = new StringBuilder();
        for (int i = L; i <= R; i++) {
            if (i % 2 == 0) {
                longest.append(chars[i]);
            }
        }
        return longest.toString();
    }

    private String preProcessing(String s) {
        StringBuilder ns = new StringBuilder("@#");
        for (char c : s.toCharArray()) {
            ns.append(c).append("#");
        }
        return ns.toString();
    }
}

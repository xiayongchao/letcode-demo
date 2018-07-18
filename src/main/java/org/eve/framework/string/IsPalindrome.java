package org.eve.framework.string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * @author xiayc
 * @date 2018/7/17
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        if ("".equals(s)) {
            return true;
        }
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        char[] chars = s.toCharArray();
        int lp = 0, rp = chars.length - 1;
        while (lp < rp) {
            if (chars[lp] != chars[rp]) {
                return false;
            }
            lp++;
            rp--;
        }
        return true;
    }
}

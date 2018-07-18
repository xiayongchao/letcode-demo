package org.eve.framework.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiayc
 * @date 2018/7/17
 */
public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("  -0012a42"));

        System.out.println(myAtoi("+"));
        System.out.println(myAtoi("-"));
        System.out.println(myAtoi("3.14159"));
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("       "));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        //-1:-,1:+,0:未处理,2:无符号+
        int nature = 0;
        List<Character> list = new ArrayList<>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                if (nature != 0) {
                    break;
                }
                continue;
            }
            if (chars[i] != '-' && chars[i] != '+' && chars[i] != '.' && (chars[i] < '0' || chars[i] > '9')) {
                if (nature == 0) {
                    return 0;
                }
                break;
            }
            if (chars[i] == '.') {
                break;
            }
            if (chars[i] == '-') {
                if (nature != 0) {
                    break;
                }
                nature = -1;
            } else if (chars[i] == '+') {
                if (nature != 0) {
                    break;
                }
                nature = 1;
            } else {
                nature = 2;
            }
            list.add(chars[i]);
        }
        if (list.size() == 0) {
            return 0;
        }
        if (list.size() == 1 && (list.get(0) == '-' || list.get(0) == '+')) {
            return 0;
        }
        chars = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            chars[i] = list.get(i);
        }
        try {
            return Integer.parseInt(new String(chars));
        } catch (NumberFormatException e) {
            if (chars[0] == '-') {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
    }
}

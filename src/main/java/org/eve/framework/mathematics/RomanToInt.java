package org.eve.framework.mathematics;

import java.util.Stack;

/**
 * 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/25/math/63/
 *
 * @author jc
 * @date 2019/9/22 14:38
 */
public class RomanToInt {
    public static void main(String[] args) {
        //3
        System.out.println(new RomanToInt().romanToInt("III"));
        //4
        System.out.println(new RomanToInt().romanToInt("IV"));
        //9
        System.out.println(new RomanToInt().romanToInt("IX"));
        //58
        System.out.println(new RomanToInt().romanToInt("LVIII"));
        //1994
        System.out.println(new RomanToInt().romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        Integer top = null, num;
        for (int i = 0; i < chars.length; i++) {
            num = convertToNumber(chars[i]);
            if (top == null) {
                top = num;
                stack.push(num);
                continue;
            }
            if ((top == 1 && (num == 5 || num == 10))
                    || (top == 10 && (num == 50 || num == 100))
                    || (top == 100 && (num == 500 || num == 1000))) {
                stack.pop();
                stack.push(num - top);
                top = num;
            } else {
                stack.push(num);
                top = num;
            }
        }
        int count = 0;
        while (!stack.isEmpty()) {
            count = count + stack.pop();
        }
        return count;
    }

    private int convertToNumber(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

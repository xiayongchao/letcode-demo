package org.eve.framework.other;

import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/68/
 *
 * @author xiayc
 * @date 2019/9/23
 */
public class IsValid {
    public static void main(String[] args) {
//        System.out.println(new IsValid().isValid("()"));
//        System.out.println(new IsValid().isValid("()[]{}"));
//        System.out.println(new IsValid().isValid("(]"));
        System.out.println(new IsValid().isValid("["));
        System.out.println(new IsValid().isValid("]"));
        System.out.println(new IsValid().isValid("([)]"));
        System.out.println(new IsValid().isValid("{[]}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (stack.isEmpty() && (c == ')' || c == ']' || c == '}')) {
                return false;
            }
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (c == ')' && !stack.pop().equals('(')) {
                return false;
            }
            if (c == ']' && !stack.pop().equals('[')) {
                return false;
            }
            if (c == '}' && !stack.pop().equals('{')) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

package org.eve.framework.backtrackingalgorithm;

import org.eve.framework.Gsons;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/92/
 * <p>
 * 参考：https://blog.csdn.net/weixin_42156844/article/details/82979920
 *
 * @author jc
 * @date 2019/10/8 23:28
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(Gsons.getJson(new Solution().generateParenthesis(3)));
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> parenthesis = new ArrayList<>(n * 2);
            generateParenthesis(parenthesis, new char[n * 2], 0, 0, 0);
            return parenthesis;
        }

        private void generateParenthesis(List<String> parenthesis, char[] chars, int pos, int left, int right) {
            if (right > left || left > chars.length / 2 || right > chars.length) {
                //回溯的关键，进行剪枝
                return;
            }
            if (chars.length == pos) {
                parenthesis.add(new String(chars));
            } else {
                chars[pos] = '(';
                generateParenthesis(parenthesis, chars, pos + 1, left + 1, right);
                chars[pos] = ')';
                generateParenthesis(parenthesis, chars, pos + 1, left, right + 1);
            }
        }
    }
}

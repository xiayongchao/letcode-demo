package org.eve.framework.backtrackingalgorithm;

import org.eve.framework.Gsons;

import java.util.ArrayList;
import java.util.List;

/**
 * copy至最佳解答
 * 电话号码的字母组合
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/91/
 *
 * @author jc
 * @date 2019/10/4 14:22
 */
public class LetterCombinations_v2 {

    public static void main(String[] args) {
        System.out.println(Gsons.getJson(new LetterCombinations_v2().letterCombinations("23")));
    }

    public List<String> letterCombinations(String digits) {
        char[][] chs = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        char[] str = new char[digits.length()];
        int[] dits = new int[digits.length()];
        int j, i, size = 1;

        int[] num = new int[digits.length()];
        for (i = 0; i < digits.length(); i++) {
            dits[i] = digits.charAt(i) - '2';
            size *= chs[dits[i]].length;
            str[i] = chs[dits[i]][0];
        }

        ArrayList<String> rs = new ArrayList<String>(size);

        if (0 != digits.length())
            rs.add(new String(str));

        while (true) {
            int add = 1;
            for (j = num.length - 1; j >= 0 && 0 != add; j--) {
                num[j] = num[j] + add;
                if (num[j] == chs[dits[j]].length) {
                    num[j] = 0;
                    str[j] = chs[dits[j]][0];
                } else {
                    add = 0;
                    str[j] = chs[dits[j]][num[j]];
                }
            }
            if (0 == add) {
                rs.add(new String(str));
            } else {
                break;
            }
        }
        return rs;
    }
}

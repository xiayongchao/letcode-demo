package org.eve.framework.backtrackingalgorithm;

import org.eve.framework.Gsons;

import java.util.*;

/**
 * 电话号码的字母组合
 * 18%
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/91/
 *
 * @author jc
 * @date 2019/10/4 14:22
 */
public class LetterCombinations_v1 {

    public static void main(String[] args) {
        System.out.println(Gsons.getJson(new LetterCombinations_v1().letterCombinations("")));
        System.out.println(Gsons.getJson(new LetterCombinations_v1().letterCombinations("23")));
    }

    private final static Map<Character, List<Character>> map = new HashMap<Character, List<Character>>() {
        {
            put('2', Arrays.asList('a', 'b', 'c'));
            put('3', Arrays.asList('d', 'e', 'f'));
            put('4', Arrays.asList('g', 'h', 'i'));
            put('5', Arrays.asList('j', 'k', 'l'));
            put('6', Arrays.asList('m', 'n', 'o'));
            put('7', Arrays.asList('p', 'q', 'r', 's'));
            put('8', Arrays.asList('t', 'u', 'v'));
            put('9', Arrays.asList('w', 'x', 'y', 'z'));
        }
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            return null;
        }
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        return buildString(digits.toCharArray(), 0);
    }

    private List<String> buildString(char[] chars, int start) {
        if (start >= chars.length) {
            return null;
        }
        List<String> prevResult = buildString(chars, start + 1);

        List<Character> characters = map.get(chars[start]);
        List<String> result = new ArrayList<>();
        if (prevResult == null) {
            for (Character character : characters) {
                result.add(new String(new char[]{character}));
            }
        } else {
            for (String s : prevResult) {
                for (Character character : characters) {
                    result.add(character + s);
                }
            }
        }
        return result;
    }
}

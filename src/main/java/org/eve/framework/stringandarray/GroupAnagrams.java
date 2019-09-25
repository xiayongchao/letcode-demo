package org.eve.framework.stringandarray;

import org.eve.framework.Gsons;

import java.util.*;

/**
 * 字谜分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/77/
 * <p>
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @author jc
 * @date 2019/9/25 0:17
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        int c = 0;
        for (int i = 1; i < 27; i++) {
            c = c + i;
        }
        System.out.println(c);

        System.out.println((int) 'a');
        System.out.println((char) 122);
        List<List<String>> lists = new GroupAnagrams().groupAnagrams(new String[]{"ron", "huh", "gay", "tow", "moe", "tie", "who", "ion", "rep", "bob", "gte", "lee", "jay", "may", "wyo", "bay", "woe", "lip", "tit", "apt", "doe", "hot", "dis", "fop", "low", "bop", "apt", "dun", "ben", "paw", "ere", "bad", "ill", "fla", "mop", "tut", "sol", "peg", "pop", "les"});
//        List<List<String>> lists = new GroupAnagrams().groupAnagrams(new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"});
//        List<List<String>> lists = new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> list : lists) {
            System.out.println(Gsons.getJson(list));
        }
    }

    private int hash(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars).hashCode();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        List<String> list;
        Map<Integer, List<String>> map = new HashMap<>(strs.length);
        int hash;
        for (String str : strs) {
            hash = hash(str);
            if (map.containsKey(hash)) {
                list = map.get(hash);
            } else {
                list = new ArrayList<>();
                map.put(hash, list);
            }
            list.add(str);
        }
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            lists.add(entry.getValue());
        }
        return lists;
    }
}

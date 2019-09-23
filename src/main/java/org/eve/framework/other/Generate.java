package org.eve.framework.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 帕斯卡三角形
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/26/others/67/
 *
 * @author jc
 * @date 2019/9/24 0:29
 */
public class Generate {
    public static void main(String[] args) {
        List<List<Integer>> lists = new Generate().generate(5);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>(numRows);
        List<Integer> list, plist = null;
        int r, l, k;
        for (int i = 1; i <= numRows; i++) {
            list = new ArrayList<>(i);
            if (plist == null) {
                list.add(1);
            } else {
                for (int j = 0; j < i; j++) {
                    r = j >= plist.size() ? 0 : plist.get(j);
                    l = (k = j - 1) >= plist.size() || k < 0 ? 0 : plist.get(k);
                    list.add(r + l);
                }
            }
            plist = list;
            lists.add(list);
        }
        return lists;
    }
}

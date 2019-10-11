package org.eve.framework.backtrackingalgorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/95/
 *
 * @author jc
 * @date 2019/10/11 22:06
 */
public class Exist {
    public static void main(String[] args) {
        /**
         * 给定 word = "ABCCED", 返回 true.
         * 给定 word = "SEE", 返回 true.
         * 给定 word = "ABCB", 返回 false.
         */
        System.out.println(new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
        System.out.println(new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "SEE"));
        System.out.println(new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCB"));

        System.out.println(new Solution().exist(new char[][]{
                {'a'}
        }, "a"));

    }

    static class Solution {
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == words[0]) {
                        if (exist(board, words, i, j, 0, new HashSet<>(words.length))) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private boolean exist(char[][] board, char[] words, int x, int y, int pos, Set<String> history) {
            if (pos == words.length) {
                return true;
            }
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                return false;
            }

            String key = x + "," + y;
            if (history.contains(key) || board[x][y] != words[pos]) {
                return false;
            }
            history.add(key);
            //上
            if (exist(board, words, x - 1, y, pos + 1, history)
                    //下
                    || exist(board, words, x + 1, y, pos + 1, history)
                    //左
                    || exist(board, words, x, y - 1, pos + 1, history)
                    //右
                    || exist(board, words, x, y + 1, pos + 1, history)) {
                history.remove(key);
                return true;
            }
            history.remove(key);
            return false;
        }
    }
}

package org.eve.framework.array;

import org.eve.framework.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/30/
 *
 * @author xiayc
 * @date 2018/7/13
 */
public class IsValidSudoku {
    public static void main(String[] args) {
        System.out.println(isValidSudoku(Utils.jsonToObject("[\n" +
                "  [\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],\n" +
                "  [\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],\n" +
                "  [\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],\n" +
                "  [\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],\n" +
                "  [\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],\n" +
                "  [\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],\n" +
                "  [\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],\n" +
                "  [\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],\n" +
                "  [\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]\n" +
                "]", char[][].class)));
        System.out.println(isValidSudoku(Utils.jsonToObject("[\n" +
                "  [\"8\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],\n" +
                "  [\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],\n" +
                "  [\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],\n" +
                "  [\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],\n" +
                "  [\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],\n" +
                "  [\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],\n" +
                "  [\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],\n" +
                "  [\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],\n" +
                "  [\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]\n" +
                "]", char[][].class)));

    }

    public static boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>(9);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i == j) {
                    set.clear();
                    for (int k = 0; k < board.length; k++) {
                        if ('.' == board[j][k]) {
                            continue;
                        }
                        if (set.contains(board[j][k])) {
                            return false;
                        }
                        set.add(board[j][k]);
                    }
                    set.clear();
                    for (int k = 0; k < board.length; k++) {
                        if ('.' == board[k][j]) {
                            continue;
                        }
                        if (set.contains(board[k][j])) {
                            return false;
                        }
                        set.add(board[k][j]);
                    }
                }

                if ((i + 1) % 3 == 1 && (j + 1) % 3 == 1) {
                    set.clear();
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            if ('.' == board[k][l]) {
                                continue;
                            }
                            if (set.contains(board[k][l])) {
                                return false;
                            }
                            set.add(board[k][l]);
                        }
                    }
                }
            }
        }
        return true;
    }
}

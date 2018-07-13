package org.eve.framework.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiayc
 * @date 2018/7/13
 */
public class IsValidSudoku {
    public static void main(String[] args) {
        char[][] chars = Utils.jsonToObject("[\n" +
                "  [\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],\n" +
                "  [\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],\n" +
                "  [\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],\n" +
                "  [\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],\n" +
                "  [\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],\n" +
                "  [\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],\n" +
                "  [\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],\n" +
                "  [\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],\n" +
                "  [\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]\n" +
                "]", char[][].class);
        isValidSudoku(chars);
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>(9);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i == j) {
                    for (int k = 0; k < board.length; k++) {
                        if (set.contains(board[j][k])) {
                            return false;
                        }
                        set.add(board[j][k]);
                    }
                    set.clear();
                    for (int k = 0; k < board.length; k++) {
                        if (set.contains(board[k][j])) {
                            return false;
                        }
                        set.add(board[k][j]);
                    }
                }
                if ((i + 1) % 3 == 1 && (j + 1) % 3 == 1) {
                    for (int k = 0; k < board.length; k++) {
                        
                    }
                }
            }
        }
        return true;
    }
}

package org.eve.framework;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * @author xiayc
 * @date 2018/7/12
 */
public class Utils {
    public static void print(int[] nums) {
        if (nums == null) {
            return;
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void print(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[] newIntArray(int... array) {
        return array;
    }

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public static <T> T jsonToObject(String json, Class<T> valueType) {
        try {
            return JSON_MAPPER.readValue(json, valueType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toString(List<Character> list){
        return null;
    }
}

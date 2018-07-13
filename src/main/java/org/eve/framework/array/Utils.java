package org.eve.framework.array;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

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
}

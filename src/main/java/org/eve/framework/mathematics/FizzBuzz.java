package org.eve.framework.mathematics;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * <p>
 * -->  1. 如果 n 是3的倍数，输出“Fizz”；
 * <p>
 * -->  2. 如果 n 是5的倍数，输出“Buzz”；
 * <p>
 * -->  3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/25/math/60/
 *
 * @author jc
 * @date 2019/9/22 14:17
 */
public class FizzBuzz {
    public static void main(String[] args) {
        List<String> list = new FizzBuzz().fizzBuzz(15);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        int m3 = 0, m5 = 0;
        for (int i = 1; i <= n; i++) {
            m3++;
            m5++;
            if (m3 == 3 && m5 == 5) {
                list.add("FizzBuzz");
                m3 = m5 = 0;
            } else if (m3 == 3) {
                list.add("Fizz");
                m3 = 0;
            } else if (m5 == 5) {
                list.add("Buzz");
                m5 = 0;
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}

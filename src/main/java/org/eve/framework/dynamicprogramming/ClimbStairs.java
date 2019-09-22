package org.eve.framework.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/54/
 *
 * @author jc
 * @date 2019/9/21 0:04
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(2));
        System.out.println(new ClimbStairs().climbStairs(3));
    }

    public int climbStairs(int n) {
        return climbStairs(n, new HashMap<>());
    }

    private int climbStairs(int n, Map<Integer, Integer> memo) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int i = n - 1;
        int n_1;
        if (memo.containsKey(i)) {
            n_1 = memo.get(i);
        } else {
            n_1 = climbStairs(i, memo);
            memo.put(i, n_1);
        }

        int j = n - 2;
        int n_2;
        if (memo.containsKey(j)) {
            n_2 = memo.get(j);
        } else {
            n_2 = climbStairs(j, memo);
            memo.put(j, n_2);
        }
        return n_1 + n_2;
    }
}

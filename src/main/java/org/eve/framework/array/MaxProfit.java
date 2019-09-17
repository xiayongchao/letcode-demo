package org.eve.framework.array;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/22/
 *
 * @author xiayc
 * @date 2019/9/16
 */
public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new MaxProfit().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new MaxProfit().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new MaxProfit().maxProfit(new int[]{3, 2, 6, 5, 0, 3}));
    }

    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int[] memo = new int[prices.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }
        int maxProfit = maxProfit(prices, 0, memo);
        return maxProfit;
    }

    public int maxProfit(int[] prices, int start, int[] memo) {
        if (prices == null || start >= prices.length - 1) {
            return 0;
        }
        int max = 0, temp;
        boolean first = true;
        for (int in = start; in < prices.length - 1; in++) {
            if (first && in + 1 < prices.length && prices[in + 1] <= prices[in]) {
                continue;
            }
            first = false;
            if (memo[in] > -1) {
                temp = memo[in];
            } else {
                temp = maxProfit(prices, in, in + 1, memo);
            }

            if (max < temp) {
                max = temp;
            }
        }
        memo[start] = max;
        return max;
    }

    public int maxProfit(int[] prices, int in, int out, int[] memo) {
        for (; out < prices.length; out++) {
            if (prices[out] <= prices[in]) {
                continue;
            }
            if (out + 1 < prices.length && memo[out] > -1) {
                return prices[out] - prices[in] + memo[out];
            } else {
                return prices[out] - prices[in] + maxProfit(prices, out, memo);
            }
        }
        return 0;
    }
}

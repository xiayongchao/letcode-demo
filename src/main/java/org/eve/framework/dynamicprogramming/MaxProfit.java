package org.eve.framework.dynamicprogramming;

/**
 * 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/55/
 *
 * @author jc
 * @date 2019/9/21 12:55
 */
public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new MaxProfit().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        boolean start = false;
        int max = 0, temp;
        for (int in = 0; in < prices.length; in++) {
            if (!start && (in + 1) < prices.length && prices[in] > prices[in + 1]) {
                start = true;
                continue;
            }
            if ((temp = maxProfit(in, prices)) > max) {
                max = temp;
            }
        }
        return max;
    }

    public int maxProfit(int in, int[] prices) {
        int max = 0, temp;
        for (int out = in + 1; out < prices.length; out++) {
            if (prices[in] >= prices[out]) {
                continue;
            }
            if ((temp = prices[out] - prices[in]) > max) {
                max = temp;
            }

        }
        return max;
    }
}

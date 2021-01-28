package com.zpl.lib.offer.o63;

/**
 * 股票的最大利润
 */
public class Solution {

    public int getMaxDiff(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = prices[0];
        int maxDiff = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            int curDiff = prices[i] - min;
            if (curDiff > maxDiff) {
                maxDiff = curDiff;
            }
        }
        return maxDiff;
    }
}

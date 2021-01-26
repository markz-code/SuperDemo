package com.zpl.lib.offer.o46;

/**
 * 把数字翻译成字符串????????
 */
public class Solution {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 存储动态规划中间值
        int[] dp = new int[s.length() + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < s.length(); i++) {
            // 1.肯定会发生
            dp[i] += dp[i - 1];
            // 2.当前位与前一位可以组成一个数字时
            int i1 = Integer.parseInt(s.substring(i - 2, i));
            if (i1 >= 0 && i1 <= 25) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}

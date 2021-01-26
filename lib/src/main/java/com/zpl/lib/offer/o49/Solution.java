package com.zpl.lib.offer.o49;

/**
 * 丑数
 */
public class Solution {

    public int getUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        // 存放所有丑数
        int[] dp = new int[index];
        dp[0] = 1;
        int nextUglyIndex = 1;
        // 存储乘以2、3、5的下标（当一个数乘完，下标加1）
        int i2 = 0, i3 = 0, i5 = 0;
        // 保证数组都是排序且都是由前面丑数得来的
        while (nextUglyIndex < index) {
            int min = Math.min(dp[i2] * 2, Math.min(dp[i3] * 3, dp[i5] * 5));
            dp[nextUglyIndex] = min;
            if (dp[i2] * 2 == min) {
                i2++;
            }
            if (dp[i3] * 3 == min) {
                i3++;
            }
            if (dp[i5] * 5 == min) {
                i5++;
            }
            nextUglyIndex++;
        }
        return dp[index - 1];
    }

}
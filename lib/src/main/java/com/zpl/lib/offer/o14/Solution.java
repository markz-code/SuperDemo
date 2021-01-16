package com.zpl.lib.offer.o14;

/**
 * 剪绳子
 * <p>
 * 动态规划 or 贪心算法？？？？？？？？？
 */
public class Solution {
    public static void main(String[] args) {

    }

    private static int cutRopeByDP(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        // 创建数组存储子问题最优解
        int[] result = new int[n + 1];
        for (int i = 0; i < 4; i++) {
            result[i] = i;
        }
        // 开始求解每一个长度的最优解
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i / 2; j++) {
                int temp = result[j] * result[i - j];
                if (temp > max) {
                    max = temp;
                }
            }
            result[i] = max;
        }
        return result[n];
    }

    private static int cutRopeByGA(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int timesOfThree = n / 3;
        if (n % 3 == 1) {
            timesOfThree--;
        }

        int timeOfTwo = (n - timesOfThree * 3) / 2;
        return (int) (Math.pow(3, timesOfThree) * Math.pow(2, timeOfTwo));
    }
}

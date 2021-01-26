package com.zpl.lib.offer.o43;

/**
 * 1~n整数中1出现的次数
 */
public class Solution {

    public int numberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m;
            int b = n % m;

            int temp = a % 10;

            if (temp == 0) {
                count += a / 10 * m;
            } else if (temp == 1) {
                count += a / 10 * m + b + 1;
            } else {
                count += (a / 10 + 1) * m;
            }
        }
        return count;
    }
}

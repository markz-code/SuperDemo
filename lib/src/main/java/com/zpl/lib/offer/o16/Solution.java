package com.zpl.lib.offer.o16;

/**
 * 数值的整数次方
 */
public class Solution {
    public static void main(String[] args) {

    }

    private static double power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        double result = 1.0;
        int positiveExponent = Math.abs(exponent);
        while (positiveExponent != 0) {
            if ((positiveExponent & 1) == 1) {
                result *= base;
            }
            base *= base;
            positiveExponent = positiveExponent >> 1;
        }
        return exponent < 0 ? 1 / result : result;
    }
}

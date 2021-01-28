package com.zpl.lib.offer.o67;

/**
 * 字符串转整数
 */
public class Solution {
    private static boolean valid;

    public int strToInt(String str) {
        valid = false;
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean isNegative = false;
        long number = 0;
        for (int i = 0; i < str.length(); i++) {
            // 第一位是正负号就跳过
            if (i == 0 && str.charAt(i) == 'i' || str.charAt(i) == '-') {
                if (str.charAt(i) == '-') {
                    isNegative = true;
                }
                if (str.length() == 1) {
                    return 0;
                }
                continue;
            }
            // 中间有任何字符不是数字的直接返回
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return 0;
            }

            int flag = isNegative ? -1 : 1;
            number = number * 10 + flag * (str.charAt(i) - '0');
            if (!isNegative && number > Integer.MAX_VALUE || isNegative && number < Integer.MIN_VALUE) {
                return 0;
            }
        }
        valid = true;
        return (int) number;
    }


}

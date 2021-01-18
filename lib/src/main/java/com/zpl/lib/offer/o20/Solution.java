package com.zpl.lib.offer.o20;

/**
 * 表示数值的字符串
 */
public class Solution {

    public static boolean isNumeric(char[] str) {
        if(str == null || str.length== 0) {
            return false;
        }

        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

}

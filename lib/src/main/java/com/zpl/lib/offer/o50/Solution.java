package com.zpl.lib.offer.o50;

/**
 * 返回第一个不重复字符
 */
public class Solution {

    public char firstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0) {
            return '\0';
        }
        int[] count = new int[256];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if(count[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return '\0';
    }
}

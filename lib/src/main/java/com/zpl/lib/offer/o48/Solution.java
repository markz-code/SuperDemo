package com.zpl.lib.offer.o48;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 */
public class Solution {

    public int longestSubsingWithoutDuplication(String s) {
        int curLength = 0;
        int maxLength = 0;

        Map<Character, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Integer index = indexMap.get(s.charAt(i));
            if (index == null || (i - index) > curLength) {
                curLength++;
            } else {
                maxLength = Math.max(maxLength, curLength);
                curLength = i - index;
            }
            indexMap.put(s.charAt(i), i);
        }
        maxLength = Math.max(maxLength, curLength);
        return maxLength;
    }
}

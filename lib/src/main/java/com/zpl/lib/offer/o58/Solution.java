package com.zpl.lib.offer.o58;

/**
 *
 */
public class Solution {

    public String reverseSentence(String str) {
        if(str == null || str.trim().equals("")) return str;

        String[] words = str.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i++) {
            sb.append(words[i]);
            if(i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

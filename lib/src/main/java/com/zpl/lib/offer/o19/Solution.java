package com.zpl.lib.offer.o19;

/**
 * 正则表达式匹配????
 */
public class Solution {

    public static void main(String[] args) {
        char[] str = {'a','a','a'};
        char[] pattern = {'a','*','b'};
        System.out.println(match(str,pattern));
    }

    private static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern, 0, 0);
    }

    /**
     * @param str
     * @param pattern
     * @param i       str的下标
     * @param j       patter的下标
     * @return
     */
    private static boolean matchCore(char[] str, char[] pattern, int i, int j) {
        if (i == str.length && j == pattern.length) {
            return true;
        }
        // 当模式不足以配置字符串时
        if (i < str.length && j == pattern.length) {
            return false;
        }
        // 当模式中的第二个字符是*时：
        if (j + 1 < pattern.length && pattern[j + 1] == '*') {
// 如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式
            if (i != str.length && pattern[j] == str[i] || (pattern[j] == '.' && i != str.length)) {
                return matchCore(str, pattern, i + 1, j + 2)
                        || matchCore(str, pattern, i + 1, j)
                        || matchCore(str, pattern, i, j + 2);
            } else {
                return matchCore(str, pattern, i, j + 2);
            }
        }

        if (i != str.length && str[i] == pattern[j] || (pattern[j] == '.' && i != str.length)) {
            return matchCore(str, pattern, i + 1, j + 1);
        }

        return false;
    }
}

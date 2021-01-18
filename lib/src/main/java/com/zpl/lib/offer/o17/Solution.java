package com.zpl.lib.offer.o17;

/**
 * 考虑大数问题
 */
public class Solution {

    public static void main(String[] args) {
//        printFromToMaxOfNDigit1(3);
        printFrom1ToMaxOfNDigitRecur(3);
    }

    /**
     * 使用字符串代替数字进行运算
     *
     * @param n
     */
    public static void printFromToMaxOfNDigit1(int n) {
        if (n <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
        while (stillIncrease(sb, n)) {
            print(sb);
        }
        System.out.println();
    }

    private static boolean stillIncrease(StringBuilder sb, int len) {
        int toTen = 0;
        for (int i = len - 1; i >= 0; i--) {
            int sum = sb.charAt(i) - '0' + toTen;
            // 在个位上，先自增
            if (i == len - 1) {
                sum++;
            }
            if (sum == 10) {
                if (i == 0) {
                    return false;
                } else {
                    sb.setCharAt(i, '0');
                    toTen = 1;
                }
            } else {
                sb.setCharAt(i, (char) (sum + '0'));
                break;
            }
        }
        return true;
    }

    private static void print(StringBuilder sb) {
        int start = sb.length();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                start = i;
                break;
            }
        }
        if (start < sb.length()) {
            System.out.println(sb.substring(start) + " ");
        }
    }

    /**
     * 递归 --> 全排列
     *
     * @param n
     */
    private static void printFrom1ToMaxOfNDigitRecur(int n) {
        if (n <= 0) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
        printRecur(sb, n, -1);
        System.out.println();
    }

    private static void printRecur(StringBuilder sb, int len, int index) {
        if (index == len - 1) {
            print(sb);
            return;
        }
        for (int i = 0; i < 10; i++) {
            sb.setCharAt(index + 1, (char) (i + '0'));
            printRecur(sb, len, index + 1);
        }
    }
}


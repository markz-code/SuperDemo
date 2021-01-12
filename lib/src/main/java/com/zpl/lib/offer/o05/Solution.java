package com.zpl.lib.offer.o05;

/**
 * 替换空格
 * 尾部插入&&双指针
 */
public class Solution {

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace(buffer));
    }

    private static String replaceSpace(StringBuffer s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        // 统计字符串中的空格数
        int spaceNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                spaceNum++;
            }
        }
        // 记录旧指针
        int oldP = s.length() - 1;
        s.setLength(s.length() + 2 * spaceNum);
        // 记录新指针
        int newP = oldP + 2 * spaceNum;
        // 从后向前遍历
        while (oldP >= 0 && oldP < newP) {
            if (s.charAt(oldP) == ' ') {
                s.setCharAt(newP--, '0');
                s.setCharAt(newP--, '2');
                s.setCharAt(newP--, '%');
            } else {
                s.setCharAt(newP--, s.charAt(oldP));
            }
            oldP--;
        }
        return s.toString();
    }
}

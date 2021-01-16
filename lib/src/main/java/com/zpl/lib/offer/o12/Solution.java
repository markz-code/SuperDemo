package com.zpl.lib.offer.o12;

import com.zpl.lib.offer.Constant;

/**
 * 矩阵中的路径
 * 回溯
 */
public class Solution {

    public static void main(String[] args) {
        char[] matrix = new char[]{'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = new char[]{'b', 'f', 'c', 'e'};
        System.out.println(hasPath(matrix, 3, 4, str));
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows <= 0 || cols <= 0 || str == null) return false;
        // 标记是否访问过
        boolean[] marked = new boolean[matrix.length];
        // 所有点都要作为起点搜索一次
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathTo(matrix, rows, cols, row, col, str, 0, marked)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathTo(char[] matrix, int rows, int cols, int row, int col, char[] str, int len, boolean[] marked) {
        int index = row * cols + col;
        if (row < 0 || row >= rows || col < 0 || col > cols || matrix[index] != str[len] || marked[index]) {
            return false;
        }
        if (len == str.length - 1) {
            return true;
        }
        marked[index] = true;

        if (hasPathTo(matrix, rows, cols, row, col + 1, str, len + 1, marked) ||
                hasPathTo(matrix, rows, cols, row, col - 1, str, len + 1, marked) ||
                hasPathTo(matrix, rows, cols, row - 1, col, str, len + 1, marked) ||
                hasPathTo(matrix, rows, cols, row + 1, col, str, len + 1, marked)) {
            return true;
        }
        marked[index] = false;
        return false;
    }
}

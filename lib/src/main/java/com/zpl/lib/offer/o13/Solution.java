package com.zpl.lib.offer.o13;

/**
 * 机器人的运动范围
 * 回溯法
 */
public class Solution {

    private static int movingCount(int threshold, int rows, int cols) {
        if (threshold <= 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        // 设置一个已访问的列表
        boolean[] visited = new boolean[rows * cols];

        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private static int movingCountCore(int threshold, int rows, int cols, int i, int i1, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, i, i1, visited)) {
            visited[i * cols + i1] = true;
            count = 1 + movingCountCore(threshold, rows, cols, i + 1, i1, visited)
                    + movingCountCore(threshold, rows, cols, i - 1, i1, visited)
                    + movingCountCore(threshold, rows, cols, i, i1 + 1, visited)
                    + movingCountCore(threshold, rows, cols, i, i1 - 1, visited);
        }
        return count;
    }

    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && (getDigitSum(col) + getDigitSum(row) < threshold)) {
            return true;
        }
        return false;
    }

    private static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
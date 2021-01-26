package com.zpl.lib.offer.o47;

/**
 * 礼物的最大价值
 */
public class Solution {

    /**
     * 递归实现
     */
    public int getMax(int[] gifts, int rows, int cols) {
        if (gifts == null || gifts.length == 0) return 0;
        int[] max = {0};
        select(gifts, 0, 0, rows, cols, 0, max);
        return max[0];
    }

    /**
     * @param gifts
     * @param row
     * @param col
     * @param rows
     * @param cols
     * @param val
     * @param max
     */
    private void select(int[] gifts, int row, int col, int rows, int cols, int val, int[] max) {
        if (row >= rows || col >= cols) return;

        val += gifts[rows * cols + col];
        // 到达右下角，和max比较
        if (row == rows - 1 && col == cols - 1) {
            if (val > max[0]) max[0] = val;
        }
        select(gifts, row + 1, col, rows, cols, val, max);
        select(gifts, row, col + 1, rows, cols, val, max);
    }

    /**
     * 动态规划阶梯
     *
     * @param board
     * @return
     */
    public int getMost(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int rows = board.length;
        int columns = board[0].length;
        int[][] temp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int value = board[i][j];
                if (i == 0 && j == 0) {
                    temp[i][j] = value;
                } else if (i == 0) {
                    temp[i][j] = temp[i][j - 1] + value;
                } else if (j == 0) {
                    temp[i][j] = temp[i - 1][j] + value;
                } else {
                    temp[i][j] = Math.max(temp[i][j - 1], temp[i - 1][j]) + value;
                }
            }
        }
        return temp[rows - 1][columns - 1];
    }
}

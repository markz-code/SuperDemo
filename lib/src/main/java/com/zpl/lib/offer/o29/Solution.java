package com.zpl.lib.offer.o29;

import com.zpl.lib.offer.Constant;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<Integer> integers = printMatrix(Constant.twoArr);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }

    private static List<Integer> printMatrix(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 计算需要遍历的圈数
        int circles = (Math.min(rows, cols) - 1) / 2 + 1;
        int start = 0;
        while (start < circles) {
            int endx = cols - 1 - start;
            int endy = rows - 1 - start;
            // 从左向右打印一行
            for (int i = start; i <= endx; i++) {
                list.add(matrix[start][i]);
            }
            // 从上到下
            if (start < endy) {
                for (int i = start + 1; i <= endy; i++) {
                    list.add(matrix[i][endx]);
                }
            }
            // 从右向左
            if (start < endx && start < endy) {
                for (int i = endx - 1; i >= start; i--) {
                    list.add(matrix[endy][i]);
                }
            }
            // 从下往上
            if (start < endx && start < endy - 1) {
                for (int i = endy - 1; i > start; i--) {
                    list.add(matrix[i][start]);
                }
            }
            start++;
        }
        return list;
    }
}

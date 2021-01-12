package com.zpl.lib.offer.o04;

import com.zpl.lib.offer.Constant;

/**
 * 二维数组中查找
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(find(Constant.twoArr, 5));
        System.out.println(find(Constant.twoArr, 7));

    }

    /**
     * 先与右上角值比较，大于target则进入循环
     */
    private static boolean find(int[][] arr, int target) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            // 列数
            int length = arr[i].length;
            if (arr[i][length - 1] > target) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (target == arr[i][j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

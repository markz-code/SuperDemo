package com.zpl.lib.offer.o61;

import java.util.HashSet;
import java.util.Set;

/**
 * 扑克牌中的顺子
 */
public class Solution {

    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num :
                nums) {
            if (num == 0) continue;
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (repeat.contains(num)) {
                return false;
            }
            repeat.add(num);
        }
        return max - min < 5;
    }

}

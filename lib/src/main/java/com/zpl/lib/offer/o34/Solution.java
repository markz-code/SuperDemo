package com.zpl.lib.offer.o34;

import com.zpl.lib.offer.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 */
public class Solution {

    private static List<List<Integer>> findPath(Constant.TreeNode root, int target) {
        List<Integer> singleResult = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        findPath(root, target, singleResult, result);
        return result;
    }

    private static void findPath(Constant.TreeNode node, int target, List<Integer> singleResult, List<List<Integer>> result) {
        target -= node.val;
        singleResult.add(node.val);
        if (target == 0 && node.left == null && node.right == null) {
            result.add(new ArrayList<>(singleResult));
        }
        if (node.left != null) {
            findPath(node.left, target, singleResult, result);
        }
        if (node.right != null) {
            findPath(node.right, target, singleResult, result);
        }
        // 移除最后一个
        singleResult.remove(singleResult.size() - 1);
    }
}

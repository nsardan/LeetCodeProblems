package com.learning.binarytree;

import java.util.ArrayList;
import java.util.List;

public class ZigZagLevelOrderRecursive {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        levelOrder(levels, root, 1);
        return levels;
    }

    private void levelOrder(List<List<Integer>> levels, TreeNode root, int curLevel) {
        if (root == null) return;
        if (curLevel > levels.size()) {
            levels.add(new ArrayList<>());
        }
        if (curLevel % 2 == 1) {
            levels.get(curLevel - 1).add(root.val);
        } else {
            levels.get(curLevel - 1).add(0, root.val);
        }
        levelOrder(levels, root.left, curLevel + 1);
        levelOrder(levels, root.right, curLevel + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        ZigZagLevelOrderRecursive recursive = new ZigZagLevelOrderRecursive();
        List<List<Integer>> finalAns = recursive.zigzagLevelOrder(root);
        finalAns.stream().forEach(levels -> System.out.println(levels));
        System.out.println("****************************'");

    }
}

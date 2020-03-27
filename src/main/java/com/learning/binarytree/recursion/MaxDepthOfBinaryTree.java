package com.learning.binarytree.recursion;

import com.learning.binarytree.TreeNode;

public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        int depth = Math.max(left, right)+1;
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createBinaryTree();
        MaxDepthOfBinaryTree main = new MaxDepthOfBinaryTree();
        int depth = main.maxDepth(root);
        System.out.println("Depth : " + depth);
    }
}

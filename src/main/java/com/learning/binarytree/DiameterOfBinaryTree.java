package com.learning.binarytree;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.createBinaryTree();
        int finalAnswer = diameterOfBinaryTree(root);
        System.out.println(finalAnswer);
    }
    static int diameter;
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        depth(root);
        return diameter-1;
    }

    public static int depth(TreeNode root){
        if(root == null) return 0;
        int left_depth = depth(root.left);
        int right_depth = depth(root.right);
        diameter = Math.max(left_depth+right_depth+1, diameter);
        return 1 + Math.max(left_depth, right_depth);
    }
}

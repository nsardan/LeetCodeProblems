package com.learning.binarytree;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.createBinaryTree();
        //TreeNode root = null;
        DiameterOfBinaryTree main = new DiameterOfBinaryTree();
        int finalAnswer = main.diameterOfBinaryTree(root);
        System.out.println(finalAnswer);
    }
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        maxDepth(root);
        return diameter;
    }

    private int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        diameter = Math.max(diameter, right + left);
        return Math.max(left, right) +1;
    }
}

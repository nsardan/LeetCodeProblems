package com.learning.binarytree;

public class MaximumPathSum {

    /*
    Given a non-empty binary tree, find the maximum path sum.

    For this problem, a path is defined as any sequence of nodes from some
    starting node to any node in the tree along the parent-child connections.
    The path must contain at least one node and does not need to go through the root.
     */
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode treeNode = createBinaryTree();
        System.out.println(maxPathSum(treeNode));
    }

    public static int maxPathSum(TreeNode root) {
        calculateMaxPath(root);
        return max;
    }
    /*
                 -10
                 /  \
                9   20
                   /  \
                  15  7

     */
    public static int calculateMaxPath(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return Math.max(root.val, 0);

        int left = calculateMaxPath(root.left);
        int right = calculateMaxPath(root.right);
        int sum = root.val + Math.max(left, 0) + Math.max(right, 0);
        max = Math.max(sum, max);
        //19+20
        sum = root.val + Math.max(0, Math.max(left, right));
        return sum;
    }

    public static TreeNode createBinaryTree(){
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }


}

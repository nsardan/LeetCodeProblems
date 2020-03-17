package com.learning.binarytree.recursion;

import com.learning.binarytree.TreeNode;

public class MinDistanceBtwBSTNodes {

    int min = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        return minDiff(root);
    }

    public int minDiff(TreeNode root){
        if(root == null) return min;

        minDiff(root.left);
        if(prev != null) min = Math.min(min, root.val - prev.val);
        prev = root;
        minDiff(root.right);

        return min;
    }

    public static void main(String[] args) {
        //[4,2,6,1,3,null,null]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        MinDistanceBtwBSTNodes main = new MinDistanceBtwBSTNodes();
        System.out.println("final answer : "+ main.minDiffInBST(root));
    }
}

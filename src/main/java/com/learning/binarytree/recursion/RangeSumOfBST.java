package com.learning.binarytree.recursion;

import com.learning.binarytree.TreeNode;

public class RangeSumOfBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right= new TreeNode(18);
        RangeSumOfBST range = new RangeSumOfBST();
        System.out.println("range of ans: " + range.rangeSumBST(root, 7, 15));

    }

    /*
    Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
    Output: 32
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        if(root.val < L){
            return rangeSumBST(root.right, L, R);
        }
        if(root.val > R)
            return  rangeSumBST(root.left, L, R);
        return rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R) + root.val;

    }


}

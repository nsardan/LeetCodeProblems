package com.learning.binarytree;

public class LowestCommonAncestor{
    /*
            3
          /    \
         5      1
       /  \    / \
      6   2   0   8
         / \
        7  4

     */
    public static void main(String[] args) {
        TreeNode root = createBinaryTree();

        System.out.println(lowestCommonAncestor(root, root.left, root.right).val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p == root || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        return left == null? right: left;


    }

    public static TreeNode createBinaryTree(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        return root;
    }
}

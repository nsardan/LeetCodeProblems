package com.learning.binarytree;

import java.util.List;

public class DepthFirstTraversalRecursive {

    public static void preOrder(TreeNode root){
        if(root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(TreeNode root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }


    public static void main(String[] args) {
        TreeNode root  = createBinaryTree();
        System.out.println("-----------PreOrder--------------");
        preOrder(root);
        System.out.println();
        System.out.println("------------------PostOrder--------");
        postOrder(root);
        System.out.println();
        System.out.println("--------------InOrder------------");
        inOrder(root);
        System.out.println();
    }

    public static TreeNode createBinaryTree(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left  = new TreeNode(4);
        root.left.right = new TreeNode(5);
        return root;
    }
}

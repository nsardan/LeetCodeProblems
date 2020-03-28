package com.learning.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalIterative {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBinaryTree();
        InOrderTraversalIterative main = new InOrderTraversalIterative();
        List<Integer> finalAnswer = main.inorderTraversal(root);
        System.out.println(finalAnswer.toString());

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> finalAnswer  = new ArrayList<>();
        if(root == null) return finalAnswer;
        //inorderTraverse(root);
        finalAnswer  = iterativeInOrder(finalAnswer, root);
        return finalAnswer;
    }

    public List<Integer> iterativeInOrder(List<Integer> finalAnswer, TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            finalAnswer.add(curr.val);

            curr = curr.right;
        }


        return finalAnswer;
    }
}

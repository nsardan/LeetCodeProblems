package com.learning.binarytree;

import java.util.Stack;

import static com.learning.binarytree.TreeNode.createBinaryTree;

public class DepthFirstTraversalIterative {

    public static void main(String[] args) {
        TreeNode root  = createBinaryTree();
        System.out.println("PreOrder");
        preOrder(root);
        System.out.println();
        System.out.println("InOrder");
        //4 5 2 3 1
        inOrder(root);
        System.out.println();
        System.out.println("PostOrder");
        postOrder(root);
    }

    private static void postOrder(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        TreeNode curr = root;
        while(!s1.isEmpty()){
            if(s1.peek()!= null){
                curr = s1.pop();
                s2.push(curr);
                if(curr.left != null) s1.push(curr.left);
                if(curr.right != null) s1.push(curr.right);
            }
        }

        while(!s2.isEmpty()){
            if(s2.peek()!= null)
            {
                System.out.print(s2.pop().val + " ");
            }
        }
    }

    /*
                 1
               /  \
              2    3
             /\
            4  5

            In order :- 4 2 5 1 3
            Pre order :- 1 2 4 5 3
            Post order :- 4 5 2 3 1

     */

    private static void inOrder(TreeNode root){
        if(root == null) return;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while(true){

            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                if(stack.empty() && curr == null) break;
                TreeNode item = stack.pop();
                if(item!= null) System.out.print(item.val + " ");
                curr = item.right;
                continue;
            }
        }

    }

    private static void preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return;
        stack.add(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                System.out.print(node.val + " ");
                if(node.right != null){
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
            }
        }

    }
}

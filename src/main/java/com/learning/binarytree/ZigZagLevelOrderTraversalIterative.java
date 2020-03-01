package com.learning.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ZigZagLevelOrderTraversalIterative {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        ZigZagLevelOrderTraversalIterative main = new ZigZagLevelOrderTraversalIterative();
        List<List<Integer>> finalAnswer = main.zigzagLevelOrder(root);
        finalAnswer.stream().forEach(levels -> System.out.println(levels));
        System.out.println("****************************'");
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        finalAnswer = main.zigzagLevelOrder(root1);
        finalAnswer.stream().forEach(levels -> System.out.println(levels));
        System.out.println("****************************'");


    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> finalAnswer = new ArrayList<>();
        if(root == null) return finalAnswer;

        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        boolean leftToRight = true;
        currentLevel.push(root);
        List<Integer> levelArray = new ArrayList<>();
        while(!currentLevel.isEmpty()){

            TreeNode node = currentLevel.pop();

            levelArray.add(node.val);

            if(leftToRight){
                if(node.left != null) {
                    nextLevel.push(node.left);
                    //levelArray.add(node.left.val);
                }
                if(node.right != null) {
                    nextLevel.push(node.right);
                    //levelArray.add(node.right.val);
                }

            }else{
                if(node.right!= null) {
                    nextLevel.push(node.right);
                    // levelArray.add(node.right.val);
                }
                if(node.left != null) {
                    nextLevel.push(node.left);
                    //levelArray.add(node.left.val);
                }
                // levelArray.add(node.val);
            }

            if(currentLevel.isEmpty()){

                leftToRight = !leftToRight;
                Stack<TreeNode> tmp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tmp;
                if(levelArray.size()> 0)
                    finalAnswer.add(levelArray);
                levelArray = new ArrayList<>();

            }
        }

        return finalAnswer;
    }
}

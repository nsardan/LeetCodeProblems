package com.learning.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalIterative {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left  = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> finalAnswe = printLevelOrder(root);
        finalAnswe.stream().forEach(levels -> System.out.println(levels));
    }

    private static List<List<Integer>> printLevelOrder(TreeNode root) {
        List<List<Integer>> finalAnswer = new ArrayList<>();
        if(root == null) return finalAnswer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(true){
            int count = queue.size();
            if(count == 0) break;
            List<Integer> levelArr = new ArrayList<>();
            while(count > 0){
                TreeNode node = queue.poll();
                if(node!=null){
                    levelArr.add(node.val);
                    if(node.left != null){
                        queue.add(node.left);
                    }
                    if(node.right!= null){
                        queue.add(node.right);
                    }
                }
                count--;
            }
            finalAnswer.add(levelArr);

        }

        return finalAnswer;
    }


}



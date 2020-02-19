package com.learning.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversalRecursive {

    

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left  = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> finalAnswe = printLevelOrder(root);
        finalAnswe.stream().forEach(System.out::println);
    }

    private static List<List<Integer>> printLevelOrder(TreeNode root) {
        List<List<Integer>> finalAnswe = new ArrayList<>();
        printLevelOrderRec(root, finalAnswe, 0);
        return finalAnswe;
    }

    private static void printLevelOrderRec(TreeNode node, List<List<Integer>> finalAnswe, int level){
        if(node == null) return;
        List<Integer> levelArr;
        if(finalAnswe.size() == level){
            levelArr = new ArrayList<>();
            finalAnswe.add(levelArr);
        }else{
            levelArr = finalAnswe.get(level);
        }

        levelArr.add(node.val);
        printLevelOrderRec(node.left, finalAnswe, level+1);
        printLevelOrderRec(node.right, finalAnswe, level+1);
    }

}

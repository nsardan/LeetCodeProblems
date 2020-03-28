package com.learning.binarytree;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;

        if(s.val == t.val){
            if(!(s.left!=null && t.left!=null && s.left.val!=t.left.val) &&
                    !(s.right!=null && t.right!=null && s.right.val!=t.right.val)
                    && isSubtree(s.left, t.left) && isSubtree(s.right, t.right)) return true;
        }

        if(isSubtree(s.left, t) || isSubtree(s.right, t)) return true;

        return false;

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createBinaryTree();
        TreeNode subtree = new TreeNode(1);
        subtree.left = new TreeNode(2);
        subtree.right = new TreeNode(3);
        SubtreeOfAnotherTree main = new SubtreeOfAnotherTree();
        System.out.println(main.isSubtree(subtree, root));
    }
}

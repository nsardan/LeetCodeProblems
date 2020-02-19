package com.learning.binarytree;

import com.learning.linkedlist.ListNode;

import java.util.List;
import java.util.stream.Collectors;

public class SortedLinkedListToBinaryTree {

    static TreeNode treeNode;

    public static void main(String[] args) {
        ListNode listNode = ListNode.createLinkedListNode();
        treeNode = sortedListToBST(listNode);
        LevelOrderTraversalIterative lr = new LevelOrderTraversalIterative();
        List<List<Integer>>  levels = lr.printLevelOrder(treeNode);

        System.out.println(levels.stream().collect(Collectors.toList()));

    }
    public static TreeNode sortedListToBST(ListNode head) {
        //-10,-3,0,5,9
        TreeNode root = null;
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode slow = head;
        ListNode fast = head;
        ListNode mid = head;
        while(fast != null && fast.next !=null){
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //start with mid .. that's the tree
        mid.next = null;
        root = new TreeNode(slow.val);

        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;


    }

    private static int getLength(ListNode head) {
        if(head == null) return 0;
        int finalAnswer = 0;
        while(head != null){
            finalAnswer++;
            head = head.next;
        }
        return finalAnswer;
    }
}

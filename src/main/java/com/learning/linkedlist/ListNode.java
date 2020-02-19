package com.learning.linkedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

    public static void main(String[] args) {
        ListNode node = createLinkedListNode();

    }

    public static ListNode createLinkedListNode(){
        //0,-3,9,-10,null,5
        LinkedList<Integer> linkedList = new LinkedList(Arrays.asList(-10,-3,0,5,9));
        ListNode head = null;
        ListNode curr = null;
        Iterator<Integer> iter = linkedList.iterator();
        while(iter.hasNext()){
            ListNode newnode = new ListNode(iter.next());
            if(head == null) {
                head = newnode;
                curr = head;
            }
            else {

                curr.next = newnode;
                curr = curr.next;
            }
        }
        return head;
    }
}

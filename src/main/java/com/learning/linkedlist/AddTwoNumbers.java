package com.learning.linkedlist;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        int carry = 0;
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode curr = dummyNode;

        while(head1 != null || head2 != null){
            int x = head1 == null ? 0: head1.val;
            int y = head2 == null ? 0: head2.val;
            int sum = x + y + carry;
            carry = sum/10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(head1 != null) head1 = head1.next;
            if(head2 != null) head2 = head2.next;
        }
        if(carry>0) curr.next = new ListNode(carry);

        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers main = new AddTwoNumbers();
        ListNode finalAns = main.addTwoNumbers(l1, l2);

        while(finalAns != null){
            System.out.println(finalAns.val);
            finalAns = finalAns.next;
        }
    }
}

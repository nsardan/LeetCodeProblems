package com.learning.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

class MinStack {

    Element top;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(top == null){
            top = new Element(x, x);
        }else{
            Element e = new Element(x, Math.min(x,top.min));
            e.next = top;
            top = e;
        }

    }

    public void pop() {
        if(top == null)
            return;
        Element temp = top.next;
        top.next = null;
        top = temp;

    }

    public int top() {
        if(top == null)
            return -1;
        return top.val;
    }

    public int getMin() {
        if(top == null)
            return -1;
        return top.min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        System.out.println(min);//--> Returns -3.
        minStack.pop();
        minStack.top();      //--> Returns 0.
        min = minStack.getMin();
        System.out.println(min);
    }
}

class Element{
    int min;
    int val;
    Element next;

    public Element(int val, int min){
        this.val = val;
        this.min = min;
    }
}

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */





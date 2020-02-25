package com.learning.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(stack.isEmpty()){
            min = x;
            stack.push(x);
            return;
        }
        if(x < min){
            stack.push(2*x - min);
            min = x;
        }else{
            stack.push(x);
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            Integer integer = stack.pop();
            if(integer < min){
                min = 2*min - integer;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
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

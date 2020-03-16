package com.learning.arrays.recursion;

public class TribonacciNumber {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int mem[] = new int[n+1];
        mem[1] = 1; mem[2] = 1;
        return tribonacci(n, mem);
    }


    public int tribonacci(int n, int[] mem){
        if(n < 3) return mem[n];
        if(mem[n] != 0) return mem[n];
        mem[n] = tribonacci(n-3, mem)+ tribonacci(n-2, mem) + tribonacci(n-1, mem);
        return mem[n];
    }

    public static void main(String[] args) {
        //T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
        TribonacciNumber number = new TribonacciNumber();
        System.out.println("final Answer : " + number.tribonacci(37));
    }
}

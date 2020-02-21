package com.learning.arrays;

public class BestTimeToBuyAndSellStock121 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        //7,1,5,3,6,4
        if(prices.length == 0 || prices.length == 1) return 0;

        int min = prices[0];

        int maxdiff = 0;

        for(int i = 1; i<prices.length;i++){
            if(prices[i] < min)
                min = prices[i];
            else
                maxdiff = Math.max(maxdiff, (prices[i]- min));
        }
        return maxdiff;

    }
}

package com.learning.contest;

import java.util.Arrays;

public class MaxPoints {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int left = 0;
        int right = len -1;
        int max= 0;
        if(len == k) {
            for(int i : cardPoints){
                max = max+ i;
            }
            return max;
        }
        while(left < right &&  k> 0){
            while(k> 0 && left < right && cardPoints[left] == cardPoints[right]){
                max = max + cardPoints[left];
                k--;
                if(cardPoints[left+1] > cardPoints[right -1])   left++;
                else   right--;

            }
            if(k == 0) return max;
            if(cardPoints[left] > cardPoints[right]){
                max = max+ cardPoints[left++];
            }else{
                max = max + cardPoints[right--];
            }
            k--;
        }

        return max;

    }

    //5393. Maximum Points You Can Obtain from Cards
    public static void main(String[] args) {
        int[] cardPoints = new int[]{11,49,100,20,86,29,72};
        int k = 4;
        MaxPoints main = new MaxPoints();
        System.out.println(main.maxScore(cardPoints, k));
    }
}

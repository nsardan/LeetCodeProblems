package com.learning.contest;

import java.util.HashMap;
import java.util.Map;

public class MaxScore {

    public int maxScore(String s) {
        Map<Character, Integer> scoreMap = new HashMap<Character, Integer>();
        int maxScore = 0;
        for(int i = 0; i < s.toCharArray().length; i++){
            scoreMap.put(s.charAt(i), scoreMap.getOrDefault(s.charAt(i), 0) +1);
        }
       // System.out.println(scoreMap);
        int zeros = 0;
        int ones = scoreMap.getOrDefault('1',-1);
      //  maxScore = Math.max(maxScore, zeros + ones);
        for(int i = 0; i < s.toCharArray().length-1; i++){
            if(s.charAt(i) == '0'){
                zeros++;

            }else{

                ones--;
            }
            maxScore = Math.max(maxScore, zeros+ ones);
        }


        return maxScore;
    }


    public static void main(String[] args) {
        String s = "00";
        int output = 5;
        MaxScore main = new MaxScore();
        int ans = main.maxScore(s);
        System.out.println(ans);
    }
}

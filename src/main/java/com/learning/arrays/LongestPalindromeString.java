package com.learning.arrays;

import com.learning.string.LongestDiverseHappyString;

public class LongestPalindromeString {


    public String longestPalindrome(String s) {
        int maxLength = 1;
        int start = 0;
        int len = s.length();
        if(len == 0) return "";
        int low, high;
        //babad
        for(int i = 1; i < len; i++){
            low = i-1;
            high = i;
            //even length
            while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)){
                if(high - low + 1 > maxLength){
                    start = low;
                    maxLength = high -low +1;
                }
                --low;
                ++high;
            }

            low = i -1;
            high = i+1;
            while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)){
                if(high - low + 1 > maxLength){
                    start = low;
                    maxLength = high -low +1;
                }
                --low;
                ++high;
            }
        }


        System.out.println(maxLength);
        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String testString = "cbbd";
        LongestPalindromeString main = new LongestPalindromeString();
        String answer = main.longestPalindrome(testString);
        System.out.println(answer);

    }

}

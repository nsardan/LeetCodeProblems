package com.learning.dynamicprogramming;

public class LongestCommonSubSequence {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Array = text1.toCharArray();
        char[] text2Array = text2.toCharArray();
        int sizeText1 = text1.length();
        int sizeText2 = text2.length();

        int[][] dp = new int[sizeText1+1][sizeText2+1];
        int rows = sizeText1 +1;
        int cols = sizeText2+1;

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(row == 0 || col == 0) dp[row][col] = 0;
                else if(text1.charAt(row-1) == text2.charAt(col-1)){
                    dp[row][col] = dp[row-1][col-1] +1;
                }else{
                    dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]);
                }
            }
        }

        return dp[rows-1][cols-1];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        LongestCommonSubSequence main = new LongestCommonSubSequence();
        System.out.println(main.longestCommonSubsequence(text1, text2));
    }
}

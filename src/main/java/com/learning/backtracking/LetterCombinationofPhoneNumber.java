package com.learning.backtracking;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationofPhoneNumber {

    private HashMap<String, String> phoneMap = new HashMap<String, String>(){
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    List<String> finalAnswer = new ArrayList<String>();


    public List<String> letterCombinations(String digits) {
        if(digits.length()== 0) return finalAnswer;
        helper(digits, "");
        return finalAnswer;
    }

    public void helper(String nextDigits, String combination){
        if(nextDigits.length() == 0){
            finalAnswer.add(combination); return;
        }else{
            String digit = nextDigits.substring(0,1);
            String letters = phoneMap.get(digit);

            for(int i = 0; i < letters.length(); i++){
                String letter = phoneMap.get(digit).substring(i, i+1);
                helper(nextDigits.substring(1), combination+letter);
            }
        }

    }

    public static void main(String[] args) {
        LetterCombinationofPhoneNumber phoneNumber = new LetterCombinationofPhoneNumber();
        List<String> ans = phoneNumber.letterCombinations("23");
        ans.forEach(System.out::println);
    }
}

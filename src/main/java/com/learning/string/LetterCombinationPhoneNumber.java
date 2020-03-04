package com.learning.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinationPhoneNumber {



    public List<String> letterCombinations(String digits) {
        List<String> finalAnswer = new ArrayList<String>();
        String letters[] = {"","", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz",""};
        try{
            Integer.parseInt(digits);
        }catch (Exception e){
            return finalAnswer;
        }
        finalAnswer = letterCombinationsHelper(digits, letters, digits.length());

        return finalAnswer;
    }

    private List<String> letterCombinationsHelper(String digits, String[] letters, int length) {
        List<String> finalAnswer = new ArrayList<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add("");

        while(!queue.isEmpty()){

            System.out.println(queue.peek());
            String str = queue.remove();
            if(length == str.length()){
                finalAnswer.add(str);
            }else{
                String letter = letters[digits.charAt(str.length()) - '0'];

                //System.out.println(letter);

                for(int i = 0; i < letter.length(); i++){
                    queue.add(str+letter.charAt(i));
                }
            }
        }


        return finalAnswer;
    }


    public static void main(String[] args) {
        LetterCombinationPhoneNumber letter = new LetterCombinationPhoneNumber();
        List<String> str = letter.letterCombinations("23");
        System.out.println(str);
    }
}

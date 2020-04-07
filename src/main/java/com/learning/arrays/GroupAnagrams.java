package com.learning.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] words) {
        List<List<String>> finalAnswer = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String newWord = new String(letters);
            if(map.containsKey(newWord)){
                map.get(newWord).add(word);
            }else{
                List<String> w = new ArrayList<>();
                w.add(word);
                map.put(newWord,w);
            }
        }

        //System.out.println(map);
        for(String key : map.keySet()){
            List<String> values = map.get(key);
            if(values.size() > 0){
                finalAnswer.add(values);
            }
        }
        return finalAnswer;
    }

    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams main = new GroupAnagrams();
        List<List<String>> ans = main.groupAnagrams(words);
        ans.forEach(System.out::println);
    }




}

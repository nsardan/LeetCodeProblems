package com.learning.string;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class WordBreak {

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
       assertEquals(true, wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code")));
       assertEquals(false, wordBreak.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
       assertEquals(false, wordBreak.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
       Boolean visited[] = new Boolean[s.length()+1];
       return wordBreak(s, 0, wordDict, visited);
    }

    private boolean wordBreak(String s, int start, List<String> wordDict, Boolean visited[]) {
        if (start == s.length()) return true;
        if (visited[start] == null) {
            boolean result = false;
            String current = s.substring(start);
            for (String word : wordDict) {
                if (current.startsWith(word) && wordBreak(s, start + word.length(), wordDict, visited)) {
                    result = true;
                    break;
                }

            }
            visited[start] = result;

        }
        return visited[start];
    }
}

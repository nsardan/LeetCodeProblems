package com.learning.arrays.twodimensional;

import com.learning.string.WordBreak;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = { {'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}};

        WordSearch search = new WordSearch();
        System.out.println(search.exist(board, "ABCCED"));
    }

    public boolean exist(char[][] board, String word) {
        char[] wordChar = word.toCharArray();

        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(isExist(board, wordChar, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isExist(char[][] board, char[] wordChar, int i, int j, int index) {
        if(index == wordChar.length) return true;
        if(i < 0 || j < 0 || i == board.length || j == board[0].length) return false;
        if(wordChar[index] != board[i][j]) return false;
        board[i][j] ^= 256;

        boolean exist = isExist(board, wordChar, i+1, j, index+1) ||
                isExist(board, wordChar, i-1,j,index+1) ||
                isExist(board, wordChar, i, j+1, index+1) ||
                isExist(board, wordChar, i, j-1, index+1);
        board[i][j]^=256;
        return exist;
    }
}

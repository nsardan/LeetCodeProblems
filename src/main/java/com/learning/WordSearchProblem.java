package com.learning;

public class WordSearchProblem {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "SEE";
        WordSearchProblem problem = new WordSearchProblem();
        System.out.println(problem.exist(board, word));
    }
    public boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;
        if(word.length() > row*col) return false;
        boolean visited[][] = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col ; j++){
                if(board[i][j] == word.charAt(0)){
                    if(exist(board, visited, i, j, word, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, boolean[][] visited, int i, int j, String word, int start) {
        if(word.length() == start){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(start)){
            return false;
        }

        visited[i][j] = true;
        boolean found = false;
        if(exist(board, visited, i+1,j,word, start+1) || exist(board,visited, i, j+1, word, start+1)
                || exist(board, visited, i-1,j,word,start+1)|| exist(board, visited, i, j-1, word, start+1)){

            found = true;
        }
        if(!found)
            visited[i][j] = false;

        return found;
    }


}

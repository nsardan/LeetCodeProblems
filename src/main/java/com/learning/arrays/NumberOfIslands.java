package com.learning.arrays;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    calculateIsland(grid, i, j, row, col);
                    count++;
                }
            }
        }
        return count;
    }

    private void calculateIsland(char[][] grid, int i, int j, int row, int col) {
        if(grid[i][j] == '1') grid[i][j] = '0';
        else return;
        calculateIsland(grid, Math.max(0, i-1), j, row, col);
        calculateIsland(grid, i, Math.max(0, j-1), row, col);
        calculateIsland(grid, Math.min(row-1 ,i+1), j, row, col);
        calculateIsland(grid, i, Math.min(col-1, j+1), row, col);
    }

    /*
        '1','1','1','1','0',
        '1','1','0','1','0',
        '1','1','0','0','0'
        '0','0','0','0','0'
     */

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'}, {'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        NumberOfIslands main = new NumberOfIslands();
        System.out.println(main.numIslands(grid));
    }
}

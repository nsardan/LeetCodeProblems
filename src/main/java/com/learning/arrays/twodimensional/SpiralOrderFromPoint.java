package com.learning.arrays.twodimensional;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderFromPoint {
    /*
            1   2    3   4   5
            6   7    8   9   10
            11  12   13  14  15
            16  17   18  19  20
            21  22   23  24  25
         */

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> finalAnswer = new ArrayList<>();
        if(matrix.length == 0) return finalAnswer;

        int i, a = matrix.length/2, b = matrix[0].length/2;

        int low_row = (0 > a) ? 0 : a;
        int low_column = (0 > b) ? 0 : b - 1;
        int high_row = ((a + 1) >= matrix.length) ? matrix.length - 1 : a + 1;
        int high_column = ((b + 1) >= matrix[0].length) ? matrix[0].length - 1 : b + 1;

        while ((low_row > 0 - matrix.length && low_column > 0 - matrix[0].length))
        {
            for (i = low_column + 1; i <= high_column &&
                    i < matrix[0].length && low_row >= 0; ++i)
                finalAnswer.add(matrix[low_row][i]);
            low_row -= 1;

            for (i = low_row + 2; i <= high_row && i < matrix.length &&
                    high_column < matrix[0].length; ++i)
                finalAnswer.add(matrix[i][high_column]);
            high_column += 1;

            for (i = high_column - 2; i >= low_column &&
                    i >= 0 && high_row < matrix.length; --i)
                finalAnswer.add(matrix[high_row][i]);
            high_row += 1;

            for (i = high_row - 2; i > low_row && i >= 0
                    && low_column >= 0; --i)
                finalAnswer.add(matrix[i][low_column]);
            low_column -= 1;
        }

        return finalAnswer;
    }

    public static void main(String[] args) {
        int[][] input = createTwoDimentionalArray(5,5);
        SpiralOrderFromPoint main = new SpiralOrderFromPoint();
        List<Integer> ans = main.spiralOrder(input);
        System.out.println(ans);
    }

    public static int[][] createTwoDimentionalArray(int row, int col){
        int[][] res = new int[row][col];
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                res[i][j] = ++count;
            }
        }
        return res;
    }
}

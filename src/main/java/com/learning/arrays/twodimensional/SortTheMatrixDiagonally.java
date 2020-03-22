package com.learning.arrays.twodimensional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortTheMatrixDiagonally {

    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        if(row == 0) return mat;
        int i,j,r,c,matrixIndex;
        r = 0;
        c = col-1;
        while(r != row){
            List<Integer> toSort = new ArrayList<>();
            i = r;
            j = c;
            matrixIndex = 0;
            while (i < row && j < col){
                toSort.add(mat[i++][j++]);
            }
            if(toSort.size()>1)
                Collections.sort(toSort);


            i = r;
            j = c;
            while(i < row && j < col){
                mat[i++][j++] = toSort.get(matrixIndex++);
            }
            if(c > 0) c--;
            else r++;
        }

        return mat;
    }

    public static void main(String[] args) {
      //  [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
        int[][] input = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        SortTheMatrixDiagonally sort = new SortTheMatrixDiagonally();
        int[][] finalAnswer = sort.diagonalSort(input);
        //[1,1,1,1],[1,2,2,2],[1,2,3,3]
        int[][] finalAnswer1 = {{1,1,1,1},{1,2,2,2},{1,2,3,3}};
        boolean isEqual = Arrays.equals(finalAnswer, finalAnswer1);
        System.out.println(isEqual);
    }
}

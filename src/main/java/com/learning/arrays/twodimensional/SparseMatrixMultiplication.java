package com.learning.arrays.twodimensional;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowsA= A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;
        int[][] finalAnswer = new int[rowsA][colsB];

        for(int rowCounterA = 0; rowCounterA < rowsA; rowCounterA++){
            for(int colCounterA = 0; colCounterA < colsA; colCounterA++){
                if(A[rowCounterA][colCounterA] != 0)
                    for(int colCounterB = 0 ; colCounterB < colsB; colCounterB++){
                        if(B[colCounterA][colCounterB]!= 0)
                            finalAnswer[rowCounterA][colCounterB] += A[rowCounterA][colCounterA]*B[colCounterA][colCounterB];
                    }
            }
        }
        return finalAnswer;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1,0,0},{-1 ,0, 3}};
        int[][] B = new int[][]{{7,0,0},{0,0,0},{0,0,1}};

        SparseMatrixMultiplication main = new SparseMatrixMultiplication();
        int[][] output = main.multiply(A,B);

        for(int i = 0; i < output.length; i++){
            for(int j =0; j < output[0].length; j++){
                System.out.print(output[i][j] +" : ");
            }
            System.out.println("--");
        }
    }
}

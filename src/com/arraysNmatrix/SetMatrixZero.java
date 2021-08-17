package com.arraysNmatrix;

public class SetMatrixZero {
    public static void setZero(int[][] matrix){
        int col0 = 1;
        int rows = matrix.length;
        int column = matrix[0].length;

        for (int i = 0; i < rows; i++){
            if (matrix[i][0] == 0){
                col0 = 0;
            }
            for (int j = 1; j < column; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--){
            for (int j = column - 1; j >= 1; j--){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0){
                matrix[i][0] = 0;
            }
        }
        for (int[] nums:
             matrix) {
            System.out.println();
            for (int num:
                 nums) {
                System.out.print(num + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
        setZero(matrix);
    }
}

package com.arraysNmaths;

public class SearchIn2DMatrix {
    public static boolean search(int[][] matrix, int target){
        if (matrix.length == 0){
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int low = 0;
        int high = (row * column) -1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if (matrix[mid/column][mid%column] == target){
                return true;
            }
            if (matrix[mid/column][mid%column] < target){
                low = mid+1;
            }
            else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1,3,5,7}, {10,11,16,20},{23,30,34,50}};
        System.out.println(search(array, 30));
    }
}

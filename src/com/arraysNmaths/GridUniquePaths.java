package com.arraysNmaths;

public class GridUniquePaths {
    public static int uniquePaths(int m, int n) {
        //for calculating NCr

        int N = n + m - 2;
        int r = m - 1;
        int result = 1;
        for (int i = 1; i <= r; i++){
            result = result * (N - r + i) / i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }
}

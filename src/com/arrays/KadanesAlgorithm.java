package com.arrays;

public class KadanesAlgorithm {
    public static int maximumSubArray(int[] array, int n){
        int sum = 0;
        int max = array[0];
        for (int i = 1; i < n; i++){
            sum += array[i];
            if (sum < 0){
                sum = 0;
            }
            if (sum > max){
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maximumSubArray(array, 8));
    }
}

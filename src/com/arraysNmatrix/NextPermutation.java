package com.arraysNmatrix;

public class NextPermutation {

    public static void findNextpermutation(int[] number) {
        int i = number.length - 2;
        while (i >= 0 && number[i + 1] <= number[i]) {
            i--;
        }
        if (i >= 0) {
            int j = number.length - 1;
            while (number[j] <= number[i]) {
                j--;
            }
            swap(number, i, j);
        }
        reverse(number, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


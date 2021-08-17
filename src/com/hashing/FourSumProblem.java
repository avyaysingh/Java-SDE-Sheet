package com.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumProblem {
    public static void fourSum(int[] array, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        if (array == null || array.length == 0){
            return;
        }

        Arrays.sort(array);
        int sumIJ = 0;
        int sumLeftRight = 0;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int newTarget = target - array[i] - array[j];

                int left = j + 1;
                int right = n - 1;


                while (left < right) {

                    sumLeftRight = array[left] + array[right];

                    if (sumLeftRight < newTarget) {
                        left++;
                    } else if (sumLeftRight > newTarget) {
                        right--;
                    } else {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(array[i]);
                        quad.add(array[j]);
                        quad.add(array[left]);
                        quad.add(array[right]);

                        result.add(quad);

                        //processing the duplicates of number 3
                        while (left < right && array[left] ==quad.get(2)){
                            ++left;
                        }
                        //duplicates of number 4
                        while (left < right && array[right] == quad.get(3)){
                            --right;
                        }
                    }
                }

                //duplicates of num 2
                while (j+1<n && array[j+1] == array[j]){
                    ++j;
                }
            }
            // dups of num 1
            while (i+1<n && array[i+1] == array[i]){
                ++i;
            }
        }

        for (List<Integer> nums:
             result) {
            System.out.println();
            for (int num:
                 nums) {
                System.out.print(num + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        fourSum(array, 9);
    }
}

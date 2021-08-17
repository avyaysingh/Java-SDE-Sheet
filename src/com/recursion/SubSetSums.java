package com.recursion;

import java.util.ArrayList;
import java.util.Collections;

/*
In :
N = 3
Arr = [5, 2, 1]

O/P
0 1 2 3 5 6 7 8
 */
public class SubSetSums {
    public static void recSumSubset(int index, int sum, ArrayList<Integer> array, int N, ArrayList<Integer> sumSubset) {
        if (index == N) {
            sumSubset.add(sum);
            return;
        }
        //picking th element
        recSumSubset(index + 1, sum + array.get(index), array, N, sumSubset);

        //not picking
        recSumSubset(index + 1, sum, array, N, sumSubset);
    }

    public static ArrayList<Integer> subsetSums(ArrayList<Integer> array, int N){
        ArrayList<Integer> sums = new ArrayList<>();
        recSumSubset(0, 0, array, N, sums);
        Collections.sort(sums);
        return sums;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(5);
        array.add(2);
        array.add(1);
        ArrayList<Integer> result = subsetSums(array, 3);
        for (int nums:
             result) {
            System.out.print(nums + " ");
        }
    }
}

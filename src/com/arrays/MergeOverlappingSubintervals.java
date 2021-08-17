package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingSubintervals {

    public static void mergeIntervals(int[][] pairArray) {
        ArrayList<int[]> result = new ArrayList<>();

        if (pairArray.length == 0) {
//            return result.toArray(new int[0][]);
            System.out.println("Empty !!!");
        }

//        Arrays.sort(pairArray, (a, b) -> a[0] - b[0]);
        Arrays.sort(pairArray, Comparator.comparingInt(a -> a[0]));

        int start = pairArray[0][0];
        int end = pairArray[0][1];

        for (int[] i :
                pairArray) {
            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {
                result.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        result.add(new int[]{start, end});
        for (int[] nums :
                result) {
            for (int num :
                    nums) {
                System.out.print(num + " ");

            }
        }
//        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] pairArray = {{1, 3}, {2, 6}, {8, 10}, {9, 11}, {15, 18}};
        mergeIntervals(pairArray);
    }
}

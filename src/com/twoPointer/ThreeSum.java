package com.twoPointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSumZero(int[] array) {
        Arrays.sort(array);
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < array.length - 2; i++) {
            if (i == 0 || (i > 0 && array[i] != array[i - 1])) {
                int low = i + 1;
                int high = (array.length) - 1;
                int sum = 0 - array[i];
                while (low < high) {
                    if (array[low] + array[high] == sum) {
                        result.add(Arrays.asList(array[i], array[low], array[high]));

                        while (low < high && array[low] == array[low + 1]) {
                            low++;
                        }
                        while (low < high && array[high] == array[high - 1]) {
                            high--;
                        }

                        low++;
                        high--;
                    } else if (array[low] + array[high] < sum) {
                        low++;
                    } else {
                        high++;
                    }
                }
            }
        }
        return result;
    }

//    public static void main(String[] args) {
//        int[] array = {-1, 0, 1, 2, -1, 4};
//        List<List<Integer>> result = threeSumZero(array);
//        for (List nums :
//                result) {
//            for (Object num :
//                    nums) {
//                System.out.println(num.toString());
//            }
//        }
//    }
}

package com.arrays;


// Problem link :- https://leetcode.com/problems/sort-colors/
//variation of dutch national flag algorithm

public class SortArrayOf0s1sAnd2s {


    public static void sortColors(int[] array) {
        int low = 0;
        int mid = 0;
        int high = array.length - 1;
        int temp;

        while (mid <= high) {
            switch (array[mid]) {

                case 0:
                    temp = array[low];
                    array[low] = array[mid];
                    array[mid] = temp;
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    temp = array[mid];
                    array[mid] = array[high];
                    array[high] = temp;
                    high--;
                    break;
            }
        }
        for (int nums :
                array) {
            System.out.print(nums + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sortColors(array);
    }
}

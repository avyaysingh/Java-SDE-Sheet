package com.twoPointer;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < array.length; j++) {
            if (array[j] != array[i]) {
                i++;
                array[i] = array[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 2, 3, 3, 3};
        System.out.println(removeDuplicates(array));
    }
}

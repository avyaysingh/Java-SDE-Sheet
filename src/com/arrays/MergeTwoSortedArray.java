package com.arrays;

public class MergeTwoSortedArray {

    //using gap method by striver

    private static int nextGap(int gap) {
        if (gap <= 1) {
            return 0;
        }
        return (gap / 2) + (gap % 2);
    }

    public static void sortAndMerge(int[] array1, int n1, int[] array2, int n2) {
        int i;
        int j;
        int gap = n1 + n2;

        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            //comparing elemnents in the first array
            for (i = 0; i + gap < n1; i++) {
                if (array1[i] > array1[i + gap]) {
                    int temp = array1[i];
                    array1[i] = array1[i + gap];
                    array1[i + gap] = temp;
                }
            }

            //comparing elements in both the arrays
            //using shorthand if inside for loop to initialize j
            //:::::-------     variable = (condition) ? expressionTrue :  expressionFalse;
            for (j = gap > n1 ? gap - n1 : 0; i < n1 && j < n2; i++, j++) {
                if (array1[i] > array2[j]) {
                    int temp = array1[i];
                    array1[i] = array2[j];
                    array2[j] = temp;
                }
            }

            //comparing elements in the second array
            if (j < n2) {
                for (j = 0; j + gap < n2; j++) {
                    if (array2[j] > array2[j + gap]) {
                        int temp = array2[j];
                        array2[j] = array2[j + gap];
                        array2[j + gap] = temp;
                    }
                }
            }
        }
        for (int nums :
                array1) {
            System.out.print(nums + " ");
        }
        System.out.println();
        for (int nums :
                array2) {
            System.out.print(nums + " ");
        }
    }

    public static void main(String[] args) {
        int[] array1 = {1, 4, 7, 8, 10};
        int[] array2 = {2, 3, 9};
        sortAndMerge(array1, 5, array2, 3);
    }
}

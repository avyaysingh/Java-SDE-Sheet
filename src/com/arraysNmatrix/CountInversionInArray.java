package com.arraysNmatrix;

public class CountInversionInArray {

    private static int merge(int[] array, int[] temp, int left, int mid, int right) {
        int i;
        int j;
        int k;
        int revCount = 0;

        i = left;
        j = mid;
        k = left;

        while ((i <= mid - 1) && (j <= right)) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];

                revCount = revCount + (mid - i);
            }
        }

        while (i <= mid - 1) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }

        for (i = left; i <= right; i++) {
            array[i] = temp[i];
        }

        return revCount;

    }

    public static int mergeSort(int[] array, int[] temp, int left, int right) {
        int mid = 0;
        int revCount = 0;
        if (right > left) {
            mid = (right + left) / 2;

            revCount += mergeSort(array, temp, left, mid);
            revCount += mergeSort(array, temp, mid + 1, right);

            revCount += merge(array, temp, left, mid + 1, right);
        }

        return revCount;
    }

    public static void main(String[] args) {
        int[] arrray = {5, 3, 2, 4, 1};
        int n = arrray.length;
        int[] temp = new int[n];
        System.out.println("Number of Inversions are : " + mergeSort(arrray, temp, 0, n - 1));
    }
}

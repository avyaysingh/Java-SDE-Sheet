package com.arraysNmaths;

import java.util.ArrayList;

public class ReversePair {

    private static int mergeSort(int[] array, int low, int high) {
        if (low == high) {
            return 0;
        }
        int mid = (low + high) / 2;
        int inv = mergeSort(array, low, mid);
        inv += mergeSort(array, mid + 1, high);
        inv += merge(array, low, mid, high);
        return inv;
    }

    private static int merge(int[] array, int low, int mid, int high) {
        int count = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && array[i] > (2 * array[j])) {
                j++;
            }
            count += (j - (mid + 1));
        }

        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (array[left] <= array[right]) {
                list.add(array[left++]);
            } else {
                list.add(array[right++]);
            }
        }
        while (left <= mid) {
            list.add(array[left++]);
        }
        while (right <= high) {
            list.add(right++);
        }

        for (int i = low; i <= high; i++) {
            array[i] = list.get(i - low);
        }

        return count;
    }

    public static int reversePairs(int[] array) {
        return mergeSort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = {40, 25, 19, 12, 9, 6, 2};
        System.out.println(reversePairs(array));
    }
}

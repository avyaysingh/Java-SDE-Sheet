package com.arraysNmaths;

import java.util.ArrayList;
import java.util.List;

public class MajorityElements {

    public static int majorityElementsNbyTwoTimes(int[] array, int n) {
        int count = 0;
        int element = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                element = array[i];
            }
            if (element == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        return element;
    }

    public static void majorityElementsNbyThreeTimes(int[] array, int n) {
        int count1 = 0;
        int count2 = 0;
        int num1 = -1;
        int num2 = -1;

        int element = 0;

        for (int i = 0; i < n; i++){
            if (array[i] == num1){
                count1++;
            }
            else if (array[i] == num2){
                count2++;
            }
            else if (count1 == 0){
                num1 = array[i];
                count1++;
            }
            else if (count2 == 0){
                num2 = array[i];
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        List<Integer> list = new ArrayList<>();
        count1 = 0;
        count2 = 0;

        for (int i = 0; i < n; i++){
            if (array[i] == num1){
                count1++;
            }
            if (array[i] == num2){
                count2++;
            }
        }
        if (count1 > n/3){
            list.add(num1);
        }
        if (count2 > n/3){
            list.add(num2);
        }
        for (int num:
             list) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};
        System.out.println(majorityElementsNbyTwoTimes(array, array.length));

        int[] newArray = {1,1,1,3,3,2,2,2};
        majorityElementsNbyThreeTimes(newArray, newArray.length);
    }
}

package com.greedy;

import java.util.Arrays;

public class MinNoOfPlatforms {
    public static int requiredPlatforms(int[] arrival, int[] departure, int n) {
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int occupiedPltform = 1;
        int result = 1;
        int i = 1;
        int j = 0;
        while (i < n && j < n){
            if (arrival[i] <= departure[j]){
                occupiedPltform++;
                i++;
            }
            else if (arrival[i] > departure[j]){
                occupiedPltform--;
                j++;
            }
            if (occupiedPltform > result){
                result = occupiedPltform;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] start = {900, 940, 950, 1100, 1500, 1800};
        int[] end = {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(requiredPlatforms(start, end, 6));
    }
}

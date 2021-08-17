package com.hashing;

import java.util.HashMap;

public class LargestSubarrayWithZeroSum {
    public static int subArraySum0(int[] array) {
        int n = array.length;
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        int max = 0;
        int sum = 0;
//        sumIndexMap.put(array[0], sum);
        for (int i = 0; i < n; i++) {
            sum += array[i];
            if (sum == 0) {
                max = i + 1;
            } else {
                if (!sumIndexMap.containsKey(sum)) {
                    sumIndexMap.put(sum, i);
                }
                max = Math.max(max, i - sumIndexMap.get(sum));
            }
        }
        return max;
    }

    // web solution below:--

    public static int malLen(int[] array){
        int n = array.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for (int i = 0;i<n;i++){
            sum+=array[i];
            if (sum == 0){
                max = i+1;
            }
            else {
                if (map.get(sum) != null){
                    max = Math.max(max, i - map.get(sum));
                }
                else {
                    map.put(sum, i);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {15, -2, 2, -8, 1, 7, 10, 23};
        int[] array2 = {1, -1, 3, 2, -2, -8, 1, 7, 10, 23};
        System.out.println(subArraySum0(array2));
        System.out.println(malLen(array));
    }
}

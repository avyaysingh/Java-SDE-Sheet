package com.hashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {

    public static void twoSum(int[] array, int target) {
        int[] result = new int[2];
        int n = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - array[i])) {
                result[1] = i;
                result[0] = map.get(target - array[i]);
            }
            map.put(array[i], i);
        }

        System.out.println(result[0] + " " + result[1]);
    }

    public static void main(String[] args) {
        int[] array = {2, 6, 5, 8, 11};
        twoSum(array, 14);
    }
}

package com.hashing;

import java.util.HashMap;

public class SubarrayWithXOR {
    public static int numberOfSubarray(int[] array, int m){
        int count = 0;
        int xor = 0;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int j : array) {
            xor ^= j;
            if (frequencyMap.get(xor ^ m) != null) {
                count += frequencyMap.get(xor ^ m);
            }
            if (xor == m) {
                count++;
            }
            if (frequencyMap.get(xor) != null) {
                frequencyMap.put(xor, frequencyMap.get(xor) + 1);
            } else {
                frequencyMap.put(xor, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] aray = {4,2,2,6,4};
        System.out.println(numberOfSubarray(aray, 6));
    }
}

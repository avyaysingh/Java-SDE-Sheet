package com.hashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestSequenceCount(int[] array) {
        int longestCount = 0;
        HashSet hashSet = new HashSet();
        for (int nums :
                array) {
            hashSet.add(nums);
        }

        for (int num :
                array) {
            if (!hashSet.contains(num - 1)) {
                int currentNum = num;
                int currentCount = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentCount++;
                }
                longestCount = Math.max(longestCount, currentCount);

            }
        }
        return longestCount;
    }

    public static void main(String[] args) {
        int[] array = {102, 4, 100, 1, 101, 3, 2};
        System.out.println(longestSequenceCount(array));
    }
}

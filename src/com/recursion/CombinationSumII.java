package com.recursion;

/*
Leetcode
Qn:- given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen
numbers sum to target. You may return the combination in any order.
A number can not be repeated
The solution set must not contain duplicate combinations.
combinations should be in sorted order

IN: candidates = [10,1,2,7,6,1,5], target = 8
OUTPUT: [[1,1,6],[1,2,5],[1,7],[2,6]]
 */

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {

    public static void findCombinations(
            int index,
            int[] arr,
            int target,
            ArrayList<Integer> ds,
            ArrayList<ArrayList<Integer>> result
    ) {
        if (target == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            if (target < arr[i]) {
                break;
            }
            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ds, result);
            ds.remove(ds.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        ArrayList<ArrayList<Integer>> result = combinationSum2(candidates, target);
        for (ArrayList nums:
                result) {
            System.out.println();
            for (Object num:
                    nums) {
                System.out.print("[" + num + "]");
            }
        }
    }
}

package com.recursion;

import java.util.ArrayList;

/*
Leetcode
Qn:- given an array of distinct integers candidates and a target integer targer,
return a list of all unique combinations of candidates where the chosen
numbers sum to target. You may return the combination in any order(number can be repeated)

IN: candidates = [2,3,6,7], target = 7
OUTPUT: [[2, 2, 3], [7]]
 */
public class CombinationSum {
    public static void recCombinations(
            int index,
            int[] array,
            int target,
            ArrayList<Integer> ds,
            ArrayList<ArrayList<Integer>> result
    ) {
        if (index == array.length) {
            if (target == 0) {
                result.add(new ArrayList<>(ds));
            }
            return;
        }

        if (array[index] <= target) {
            ds.add(array[index]);
            recCombinations(index, array, target - array[index], ds, result);
            ds.remove(ds.size() - 1);
        }
        recCombinations(index + 1, array, target, ds, result);
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        recCombinations(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7, 4, 8};
        int target = 11;
        ArrayList<ArrayList<Integer>> result = combinationSum(candidates, target);
        for (ArrayList nums :
                result) {
            System.out.println();
            for (Object num :
                    nums) {
                System.out.print("[" + num + "]");
            }
        }
    }
}

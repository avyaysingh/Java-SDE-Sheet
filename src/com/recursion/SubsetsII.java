package com.recursion;


import java.util.ArrayList;
import java.util.Arrays;

/*
QN :- Given an integer array nums that may contain duplicates return all possible
subsets(the power set).
The solution set must nor contain duplicate subsets.
Return the solution in any order

In : nums = [1, 2, 2]
OP : [[], [1]. [1, 2], [1, 2, 2], [2], [2, 2]
 */
public class SubsetsII {
    public static void findSubsets(
            int index,
            int[] nums,
            ArrayList<Integer> ds,
            ArrayList<ArrayList<Integer>> result
    ) {
        result.add(new ArrayList<>(ds));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            ds.add(nums[i]);
            findSubsets(i + 1, nums, ds, result);
            ds.remove(ds.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> subsetsWithDups(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), resultList);
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        ArrayList<ArrayList<Integer>> resultList = subsetsWithDups(nums);
        for (ArrayList list :
                resultList) {
            System.out.println();
            for (Object num :
                    list) {
                System.out.print("[" + num + "]");
            }
        }
    }
}

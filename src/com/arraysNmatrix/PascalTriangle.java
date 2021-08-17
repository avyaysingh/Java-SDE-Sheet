package com.arraysNmatrix;

//to compute number at any particular index use (R-1)C(c-1)  -> Here C denotes Combination

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void printPascal(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row, pre = null;
        for (int i = 0; i < n; ++i) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = row;
            result.add(row);
        }

        for (List<Integer> nums :
                result) {
            System.out.println(nums);
        }
    }

    public static void main(String[] args) {
        printPascal(5);
    }
}

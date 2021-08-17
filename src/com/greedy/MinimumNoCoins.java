package com.greedy;

public class MinimumNoCoins {
    public static int minCoins(int v) {
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int n = denominations.length;
        int count = 0;

        for (int i = n-1; i >= 0; i--){
            while (v >= denominations[i]){
                v -= denominations[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minCoins(70));
    }
}

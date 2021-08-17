package com.arraysNmatrix;

public class StockBuyAndSell {
    public static int calculateMaxProfit(int[] array){
        int n = array.length;

        int min = Integer.MAX_VALUE;
        int profit = 0;


        for (int i = 0; i < n; i++){
            min = Math.min(min, array[i]);
            profit = Math.max(profit, (array[i] - min));
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] array = {7, 1, 5, 3, 6, 4};
        System.out.println(calculateMaxProfit(array));
    }
}

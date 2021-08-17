package com.twoPointer;

public class MaxConsecutiveOnes {
    public static int maxOnes(int[] array){
        int count=0;
        int max=0;
        for (int i = 0; i< array.length; i++){
            if (array[i] == 1){
                count++;
            }else {
                count = 0;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {1,1,0,1,1,1};
        System.out.println(maxOnes(array));
    }
}

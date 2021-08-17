package com.arrays;

public class MissingAndRepeatingNumber {
    public static void missingRepeating(int[] array, int n) {
        int x = 0;
        int y = 0;
        int xor;
        xor = array[0];
        for (int i = 1; i < n; i++) {
            xor ^= array[i];
        }

        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        //get the rightmost bit
        int setBitNumber = xor & -xor;
        System.out.println(setBitNumber);

        for (int i = 0; i < n; i++){
            if ((array[i] & setBitNumber) != 0){
                x ^= array[i];
            }
            else {
                y ^= array[i];
            }
        }

        for (int i = 1; i <= n; i++){
            if ((i & setBitNumber) != 0){
                x ^= i;
            }
            else {
                y ^= i;
            }
        }
        System.out.println("The missing number is : " + x + " and the repeating number is : " + y);
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 6, 2, 1, 1};
        missingRepeating(array, 6);
    }
}

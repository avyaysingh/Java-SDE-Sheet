package com.arrays;

public class FindDuplicateNumber {
    public static int duplicate(int[] array, int n){
        int slow = array[0];
        int fast = array[0];
        do{
            slow = array[slow];
            fast = array[array[fast]];
        }while (slow != fast);

        fast = array[0];
        while (slow != fast){
            slow = array[slow];
            fast = array[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] array = {2,5,9,6,9,3,8,9,7,1};
        System.out.print(duplicate(array, 10));
    }
}

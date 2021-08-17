package com.twoPointer;

public class TrappingRainwater {
    public static int trappingWater(int[] heights){
        int n = heights.length;
        int left = 0;
        int right = n-1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;

        while (left< right){
            if (heights[left] <= heights[right]){
                if (heights[left]> leftMax){
                    leftMax = heights[left];
                }
                result+=leftMax-heights[left];
                left++;
            }
            else{
                if (heights[right]>=rightMax){
                    rightMax = heights[right];
                }
                else {
                    result+=rightMax-heights[right];
                }
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingWater(array));
    }
}

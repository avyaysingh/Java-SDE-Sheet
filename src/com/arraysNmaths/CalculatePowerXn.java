package com.arraysNmaths;

public class CalculatePowerXn {
    public static double pow(double x, int n) {
        double answer = 1.0;
        long nNew = n;
        if (nNew < 0){
            nNew = -1 * nNew;
        }
        while (nNew > 0) {
            if (nNew % 2 == 1) {
                answer = answer * x;
                nNew -= 1;
            } else {
                x *= x;
                nNew /= 2;
            }
        }
        if (n<0){
            answer = 1.0 / answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(pow(2.00, 10));
    }
}

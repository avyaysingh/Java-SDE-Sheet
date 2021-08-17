package com.arraysNmatrix;

public class random {

    public static int xor_paths(int n, int[] w, int x, int[][] edges) {
        int count = 0;
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[0].length; j++) {
                if (edges[i][j] == x) {
                    if ((w[edges[i][j] - 1] ^ w[edges[i][j]]) == 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] w = {3, 2, 2};
        int[][] edges = {{1, 2}, {1, 3}};
        int x = 1;
        System.out.println(xor_paths(n,
                w,
                x,
                edges));
    }
}

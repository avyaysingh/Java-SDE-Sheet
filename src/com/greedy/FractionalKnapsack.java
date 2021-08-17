package com.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static double maxValue(int W, Item[] items, int n) {
        Arrays.sort(items, new FractionalComparator());

        int currentWeight = 0;
        double maxValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (items[i].weight + currentWeight <= W) {
                maxValue += items[i].value;
                currentWeight += items[i].weight;
            } else {
                int remainingWeight = W - currentWeight;
                maxValue += ((double) (items[i].value) * remainingWeight) / (double) items[i].weight;
                break;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };
        System.out.println(maxValue(50, items, 3));
    }
}

class Item {
    int value;
    int weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class FractionalComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        double r1 = (double) (a.value) / (double) (a.weight);
        double r2 = (double) (b.value) / (double) (b.weight);
        if (r1 < r2) {
            return 1;
        } else if (r1 > r2) {
            return -1;
        } else {
            return 0;
        }
    }
}

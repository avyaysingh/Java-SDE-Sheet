package com.greedy;

import java.util.Arrays;

public class JobSequencing {
    public static int[] jobScheduleing(Job[] jobs, int n) {
        Arrays.sort(jobs, (a, b) -> (b.profit - a.profit));

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (jobs[i].deadLine > max) {
                max = jobs[i].deadLine;
            }
        }
        int[] result = new int[max + 1];
        Arrays.fill(result, -1);

        int countJobs = 0;
        int totalProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = jobs[i].deadLine; j > 0; j--) {
                if (result[i] == -1) {
                    result[j] = i;
                    countJobs++;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }

        int[] ans = new int[2];
        ans[0] = countJobs;
        ans[1] = totalProfit;
        return ans;
    }

    public static void main(String[] args) {
        Job[] jobs = {
                new Job(1, 4, 20),
                new Job(2, 1, 10),
                new Job(3, 1, 40),
                new Job(4, 1, 30)
        };

        int[] ans = jobScheduleing(jobs, 4);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

}

class Job {
    int id;
    int deadLine;
    int profit;

    public Job(int id, int deadLine, int profit) {
        this.id = id;
        this.deadLine = deadLine;
        this.profit = profit;
    }
}

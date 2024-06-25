package _2024년._6월.programmers.lv3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(value -> value[0]));
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(value -> value[1]));

        int result = 0;
        int jobCount = 0;
        int end = 0;
        int jobIndex = 0;
        while(jobCount < jobs.length) {
            while(jobIndex < jobs.length && jobs[jobIndex][0] <= end) {
                priorityQueue.add(jobs[jobIndex++]);
            }

            if(priorityQueue.isEmpty()) {
                end = jobs[jobIndex][0];
            } else {
                int[] remove = priorityQueue.remove();
                result += remove[1] + end - remove[0];
                end += remove[1];
                jobCount++;
            }
        }

        return result / jobs.length;
    }
}

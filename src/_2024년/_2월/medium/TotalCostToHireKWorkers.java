package _2024년._2월.medium;

import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>();
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>();
        int left = 0;
        int right = costs.length-1;

        long result = 0;
        for(int i=0; i<k; i++) {
            while(leftQueue.size() < candidates && left <= right) {
                leftQueue.add(costs[left++]);
            }
            while(rightQueue.size() < candidates && left <= right) {
                rightQueue.add(costs[right--]);
            }

            if(!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
                if(leftQueue.peek() <= rightQueue.peek()) {
                    result += leftQueue.poll();
                } else {
                    result += rightQueue.poll();
                }
            } else if(leftQueue.isEmpty()) {
                result += rightQueue.poll();
            } else {
                result += leftQueue.poll();
            }
        }

        return result;
    }
}

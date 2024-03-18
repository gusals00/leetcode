package _2024년._3월.medium;

import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>();
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>();
        int left = 0 , right = costs.length-1;
        long cost = 0;

        for(int i=0; i<k; i++) {
            while(leftQueue.size() < candidates && left <= right) {
                leftQueue.add(costs[left++]);
            }
            while(rightQueue.size() < candidates && left <= right) {
                rightQueue.add(costs[right--]);
            }

            if(!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
                if(leftQueue.peek() <= rightQueue.peek()) {
                    cost += leftQueue.remove();
                } else {
                    cost += rightQueue.remove();
                }
            } else if(leftQueue.isEmpty()) {
                cost += rightQueue.remove();
            } else {
                cost += leftQueue.remove();
            }
        }

        return cost;
    }
}

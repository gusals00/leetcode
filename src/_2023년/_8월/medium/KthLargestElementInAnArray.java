package _2023년._8월.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int n : nums) {
            queue.add(n);

            if(queue.size() > k) {
                queue.poll();
            }
        }

        return queue.poll();
    }
}

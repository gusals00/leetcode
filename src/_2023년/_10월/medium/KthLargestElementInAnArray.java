package _2023년._10월.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.add(num);

            if(queue.size() > k) {
                queue.remove();
            }
        }

        return queue.remove();
    }
}

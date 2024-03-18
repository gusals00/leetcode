package _2024년._3월.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        Pair[] pairs = new Pair[nums1.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long maxScore = 0;
        long sum = 0;


        for(int i=0; i<nums1.length; i++) {
            pairs[i] = new Pair(nums1[i], nums2[i]);
        }
        Arrays.sort(pairs, Comparator.comparingInt(Pair::getB).reversed());

        for (Pair pair : pairs) {
            queue.add(pair.a);
            sum += pair.a;

            if(queue.size() > k) {
                sum -= queue.remove();
            }
            if(queue.size() == k) {
                maxScore = Math.max(sum * pair.b, maxScore);
            }
        }

        return maxScore;
    }

    private static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getB() {
            return b;
        }
    }
}

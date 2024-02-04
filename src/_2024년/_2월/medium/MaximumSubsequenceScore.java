package _2024년._2월.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        Pair[] pairs = new Pair[nums1.length];
        for(int i=0; i< nums1.length; i++) {
            pairs[i] = new Pair(nums1[i], nums2[i]);
        }
        Arrays.sort(pairs, Comparator.comparing(Pair::getB).reversed());
        Queue<Integer> queue = new PriorityQueue<>();

        long max = 0;
        long sum = 0;
        for (Pair pair : pairs) {
            queue.add(pair.getA());
            sum += pair.getA();

            if(queue.size() > k) {
                sum -= queue.poll();
            }
            if(queue.size() == k) {
                max = Math.max(sum * pair.getB(), max);
            }
        }

        return max;
    }

    private static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
}

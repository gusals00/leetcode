package _2023년._8월.medium;

import java.util.*;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.sum));

        for(int n1 : nums1) {
            Node node = new Node(n1, nums2[0], n1+nums2[0], 0);
            queue.add(node);
        }

        List<List<Integer>> result = new ArrayList<>();
        while(!queue.isEmpty() && k-- > 0) {
            List<Integer> list = new ArrayList<>();
            Node poll = queue.poll();
            list.add(poll.a);
            list.add(poll.b);
            result.add(list);

            if(poll.idx + 1 < nums2.length) {
                Node node = new Node(poll.a, nums2[poll.idx+1], poll.a+nums2[poll.idx+1], poll.idx+1);
                queue.add(node);
            }
        }

        return result;
    }

    class Node {
        int a;
        int b;
        int sum;
        int idx;

        public Node(int a, int b, int sum, int idx) {
            this.a = a;
            this.b = b;
            this.sum = sum;
            this.idx = idx;
        }
    }
}

package _2023년._10월.medium;

import java.util.*;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> (o[0] + o[1])));

        int min = Math.min(nums1.length, k);
        for(int i=0; i<min; i++) {
            queue.add(new int[]{nums1[i], nums2[0], 0});
        }

        while(!queue.isEmpty() && k-- > 0) {
            int[] remove = queue.remove();
            result.add(List.of(remove[0], remove[1]));

            if(remove[2]+1 < nums2.length) {
                queue.add(new int[]{remove[0], nums2[remove[2]+1], remove[2]+1});
            }
        }

        return result;
    }
}

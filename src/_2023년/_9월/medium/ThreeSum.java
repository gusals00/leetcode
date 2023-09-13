package _2023년._9월.medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();

        for(int i=0; i<nums.length-2; i++) {
            int start = i+1;
            int end = nums.length-1;

            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    set.add(list);

                    start++;
                    end--;
                } else if(sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return new ArrayList<>(set);
    }
}

package _2023년._11월.medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {
            int start = i+1;
            int end = nums.length-1;

            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                } else if(sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}

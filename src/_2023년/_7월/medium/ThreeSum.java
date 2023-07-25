package _2023년._7월.medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for(int i=0; i<nums.length-2; i++) {
            int p1 = i+1;
            int p2 = nums.length-1;

            while(p1 < p2) {
                int sum = nums[i] + nums[p1] + nums[p2];

                if(sum == 0) {
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[p1]);
                    ans.add(nums[p2]);

                    result.add(ans);
                    p1++;
                    p2--;
                } else if(sum < 0) {
                    p1++;
                } else {
                    p2--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}

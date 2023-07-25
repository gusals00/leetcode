package _2023년._7월.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hmap = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int num = target - nums[i];
            if(hmap.containsKey(num)) {
                return new int[] {hmap.get(num), i};
            }
            hmap.put(nums[i], i);
        }

        return null;
    }
}

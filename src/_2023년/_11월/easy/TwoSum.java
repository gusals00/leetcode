package _2023년._11월.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int num = target - nums[i];
            if(map.containsKey(num)) {
                return new int[] {i, map.get(num)};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}

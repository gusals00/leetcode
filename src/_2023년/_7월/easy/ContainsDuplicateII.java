package _2023년._7월.easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(hmap.containsKey(nums[i]) && Math.abs(hmap.get(nums[i])-i) <= k) {
                return true;
            }

            hmap.put(nums[i], i);
        }

        return false;
    }
}

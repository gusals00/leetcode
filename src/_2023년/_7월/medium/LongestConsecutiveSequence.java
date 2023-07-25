package _2023년._7월.medium;

import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;

        Set<Integer> set = new TreeSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int result = 1;
        int length = 1;
        int prev = Integer.MIN_VALUE;

        for(int num : set) {
            if(prev != Integer.MIN_VALUE && num == prev+1) {
                length++;
            } else {
                result = Math.max(result, length);
                length = 1;
            }
            prev = num;
        }

        result = Math.max(result, length);
        return result;
    }
}

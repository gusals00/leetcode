package _2023년._9월.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums)
            set.add(n);

        int result = 0;

        for(int n : nums) {
            int cnt = 0;

            if(set.contains(n)) {
                set.remove(n);

                cnt++;
                int left = n-1;
                int right = n+1;

                while(set.contains(left)) {
                    set.remove(left);
                    cnt++;
                    left--;
                }
                while(set.contains(right)) {
                    set.remove(right);
                    cnt++;
                    right++;
                }
            }

            result = Math.max(result, cnt);
        }

        return result;
    }
}

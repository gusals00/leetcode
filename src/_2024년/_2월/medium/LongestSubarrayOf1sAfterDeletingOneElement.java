package _2024년._2월.medium;

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int start = 0;
        int max = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                zeroCount++;
            }

            while(zeroCount > 1) {
                 if(nums[start] == 0) {
                     zeroCount--;
                 }
                 start++;
            }

            max = Math.max(i-start+1, max);
        }

        return max-1;
    }
}

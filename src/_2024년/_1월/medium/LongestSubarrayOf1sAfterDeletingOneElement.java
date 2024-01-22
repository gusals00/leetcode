package _2024년._1월.medium;

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int zeroIndex = -1;
        int oneCount = 0;
        int max = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                if(zeroIndex != -1) {
                    oneCount = i - (zeroIndex+1);
                }
                zeroIndex = i;
            } else {
                oneCount++;
            }
            max = Math.max(max, oneCount);
        }

        return max == nums.length ? max-1 : max;
    }
}

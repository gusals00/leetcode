package _2024년._1월.medium;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int length = 1;
        for(int i=1; i<nums.length; i++) {
            if(dp[length-1] < nums[i]) {
                dp[length++] = nums[i];
            } else if(dp[length-1] > nums[i]) {
                int index = binarySearch(dp, 0, length - 1, nums[i]);
                dp[index] = nums[i];
            }
        }

        return length;
    }

    private int binarySearch(int[] dp, int start, int end, int target) {
        while(start < end) {
            int mid = (start+end)/2;
            if(dp[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }
}

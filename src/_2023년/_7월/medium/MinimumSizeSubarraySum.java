package _2023년._7월.medium;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        while(end < nums.length) {
            sum += nums[end++];

            while(sum >= target) {
                result = Math.min(end-start, result);
                sum -= nums[start++];
            }
        }

        if(result == Integer.MAX_VALUE)
            return 0;

        return result;
    }
}

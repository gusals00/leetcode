package _2023년._11월.medium;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;

        while(right < nums.length) {
            sum += nums[right++];

            while(sum >= target) {
                result = Math.min(result, right-left);
                sum -= nums[left++];
            }
        }

        if(result == Integer.MAX_VALUE)
            return 0;
        else
            return result;
    }
}

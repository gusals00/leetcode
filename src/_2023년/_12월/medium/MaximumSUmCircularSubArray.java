package _2023년._12월.medium;

public class MaximumSUmCircularSubArray {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int curMax = 0;
        int curMin = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++) {
            curMax = Math.max(curMax+nums[i], nums[i]);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin+nums[i], nums[i]);
            minSum = Math.min(minSum, curMin);

            sum += nums[i];
        }

        return maxSum < 0 ? maxSum : Math.max(maxSum, sum - minSum);
    }
}

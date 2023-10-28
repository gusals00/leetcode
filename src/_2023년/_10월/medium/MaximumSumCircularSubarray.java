package _2023년._10월.medium;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int curMax = 0;
        int curMin = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            curMax += nums[i];
            max = Math.max(max, curMax);
            curMax = Math.max(0, curMax);

            curMin += nums[i];
            min = Math.min(min, curMin);
            curMin = Math.min(0, curMin);

            sum += nums[i];
        }

        return max < 0 ? max : Math.max(max , sum-min);
    }
}

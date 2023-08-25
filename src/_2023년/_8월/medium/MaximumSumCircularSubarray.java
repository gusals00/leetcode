package _2023년._8월.medium;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int cur1 = 0;
        int cur2 = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            cur1 += nums[i];
            max = Math.max(max, cur1);
            cur1 = Math.max(0, cur1);

            cur2 += nums[i];
            min = Math.min(min, cur2);
            cur2 = Math.min(0, cur2);

            sum += nums[i];
        }

        return max < 0 ? max : Math.max(max , sum-min);
    }
}

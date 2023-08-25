package _2023년._8월.medium;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];

        for(int i=1; i<nums.length; i++) {
            result[i] = Math.max(result[i-1]+nums[i], nums[i]);
        }

        int res = Integer.MIN_VALUE;
        for(int i=0; i<result.length; i++) {
            if(res < result[i])
                res = result[i];
        }

        return res;
    }
}

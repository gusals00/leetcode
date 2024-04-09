package _2024년._4월.medium;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int min = nums[0];
        int max = nums[0];

        for(int i=1; i<nums.length; i++) {
            int num = nums[i];
            int tempMax = max;

            max = Math.max(num, Math.max(max * num, min * num));
            min = Math.min(num, Math.min(tempMax * num, min * num));

            result = Math.max(result, max);
        }

        return result;
    }
}

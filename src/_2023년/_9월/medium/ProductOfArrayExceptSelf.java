package _2023년._9월.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);

        int left = 1, right = 1;

        for(int i=0; i<n; i++) {
            result[i] *= left;
            left *= nums[i];

            result[n-i-1] *= right;
            right *= nums[n-i-1];
        }

        return result;
    }
}

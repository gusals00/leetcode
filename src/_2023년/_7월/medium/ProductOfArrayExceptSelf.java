package _2023년._7월.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);

        int cur = 1;
        for(int i=0; i<n; i++) {
            result[i] *= cur;
            cur *= nums[i];
        }

        cur=1;
        for(int i=n-1; i>=0; i--) {
            result[i] *= cur;
            cur *= nums[i];
        }

        return result;
    }
}

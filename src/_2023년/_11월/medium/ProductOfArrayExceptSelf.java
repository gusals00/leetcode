package _2023년._11월.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, 1);

        int leftPrev = 1;
        int rightPrev = 1;
        for(int i = 0; i< length; i++) {
            result[i] *= leftPrev;
            leftPrev *= nums[i];

            result[length-i-1] *= rightPrev;
            rightPrev *= nums[length-i-1];
        }

        return result;
    }
}

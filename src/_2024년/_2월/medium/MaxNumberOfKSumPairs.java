package _2024년._2월.medium;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;

        int result = 0;
        while(start < end) {
            int sum = nums[start] + nums[end];
            if(sum == k) {
                result++;
                start++;
                end--;
            } else if(sum < k){
                start++;
            } else {
                end--;
            }
        }

        return result;
    }
}

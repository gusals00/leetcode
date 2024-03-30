package _2024년._3월.medium;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length-1];

        for(int i=0; i+2<nums.length; i++) {
            int start = i+1;
            int end = nums.length-1;
            int select = nums[i];

            while(start < end) {
                int sum = nums[start] + nums[end] + select;

                if(sum > target) {
                    end--;
                } else if(sum < target) {
                    start++;
                } else {
                    return target;
                }

                if(Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
            }

        }
        return result;
    }
}

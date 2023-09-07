package _2023년._9월.medium;

public class JumpGameII {
    public int jump(int[] nums) {
        int result = 0;
        int maxReach = 0;
        int end = 0;

        for(int i=0; i<nums.length-1; i++) {
            maxReach = Math.max(maxReach, nums[i] + i);

            if(maxReach >= nums.length-1) {
                result++;
                break;
            }

            if(i == end) {
                end = maxReach;
                result++;
            }
        }

        return result;
    }
}

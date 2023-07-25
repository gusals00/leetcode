package _2023년._7월.medium;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int lastLength = nums.length - 1;
        int maxReach = 0;

        for(int i=0; i<=maxReach; i++) {
            maxReach = Math.max(maxReach, nums[i]+i);

            if(maxReach >= lastLength) {
                return true;
            }
        }

        return false;
    }
}

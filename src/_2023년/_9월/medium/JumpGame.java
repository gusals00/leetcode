package _2023년._9월.medium;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxLength = 0;

        for(int i=0; i<=maxLength; i++) {
            maxLength = Math.max(maxLength, i + nums[i]);

            if(maxLength >= nums.length-1)
                return true;
        }

        return false;
    }
}

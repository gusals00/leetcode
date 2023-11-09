package _2023년._11월.medium;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        int last = nums.length-1;

        for(int i=0; i<=maxJump; i++) {
            if(maxJump >= last)
                return true;

            maxJump = Math.max(maxJump, i+nums[i]);
        }

        return false;
    }
}

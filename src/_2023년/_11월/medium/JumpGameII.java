package _2023년._11월.medium;

public class JumpGameII {
    public int jump(int[] nums) {
        int count = 0;
        int end = 0;
        int maxLength = 0;
        int lastLength = nums.length-1;

        for(int i=0; i<nums.length; i++) {
            if(end >= lastLength) {
                break;
            }

            maxLength = Math.max(maxLength, i+nums[i]);

            if(i == end) {
                end = maxLength;
                count++;
            }
        }

        return count;
    }
}

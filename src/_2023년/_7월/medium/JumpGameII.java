package _2023년._7월.medium;

public class JumpGameII {
    public int jump(int[] nums) {
        int result = 0;
        int end = 0;
        int farthest = 0;

        int lastLength = nums.length - 1;

        for (int i = 0; i < lastLength; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= lastLength) {
                result++;
                break;
            }
            if (i == end) {
                result++;
                end = farthest;
            }
        }

        return result;
    }
}

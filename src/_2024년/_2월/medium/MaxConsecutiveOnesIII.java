package _2024년._2월.medium;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0;
        int start = 0;
        int end = 0;
        int max = 0;

        while (end < nums.length) {
            if(nums[end] == 1) {
                end++;
            } else if(nums[end] == 0 && k > zeroCount) {
                end++;
                zeroCount++;
            } else {
                if(nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }
            max = Math.max(end-start, max);
        }

        return max;
    }
}

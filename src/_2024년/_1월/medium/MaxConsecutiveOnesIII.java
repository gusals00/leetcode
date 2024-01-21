package _2024년._1월.medium;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int zeroCount = 0;
        int start = 0;
        int end = 0;
        while(end < nums.length) {
            if(nums[end] == 1) {
                end++;
            } else if(nums[end] == 0 && zeroCount < k) {
                end++;
                zeroCount++;
            } else {
                if(nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }
            max = Math.max(max, end-start);
        }

        return max;
    }
}

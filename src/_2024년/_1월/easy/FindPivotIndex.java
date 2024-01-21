package _2024년._1월.easy;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int left = 0;
        int right = sum-nums[0];
        if(left == right) {
            return 0;
        }

        for(int i=1; i<nums.length; i++) {
            left += nums[i-1];
            right -= nums[i];
            if(left == right) {
                return i;
            }
        }

        return -1;
    }
}

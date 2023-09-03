package _2023년._9월.easy;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        int prev = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != prev) {
                nums[result++] = nums[i];
                prev = nums[i];
            }
        }

        return result;
    }
}

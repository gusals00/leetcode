package _2023년._11월.easy;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int pointer = 0;
        int prev = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != prev) {
                prev = nums[i];
                nums[pointer++] = nums[i];
            }
        }

        return pointer;
    }
}

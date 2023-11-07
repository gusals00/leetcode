package _2023년._11월.medium;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int pointer = 0;
        int prev = Integer.MIN_VALUE;
        int cnt = 1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != prev) {
                cnt = 1;
                nums[pointer++] = nums[i];
                prev = nums[i];
            } else if(cnt < 2) {
                cnt++;
                nums[pointer++] = nums[i];
            }
        }

        return pointer;
    }
}

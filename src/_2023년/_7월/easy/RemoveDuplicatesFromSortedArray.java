package _2023년._7월.easy;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int length = nums.length;

        for(int i = 0; i< length-1; i++) {
            if(nums[i] != nums[i+1]) {
                nums[index++] = nums[i+1];
            }
        }

        return index;
    }
}

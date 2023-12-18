package _2023년._12월.medium;

public class RemoveDuplicatesFromSortedListII {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int prevNum = nums[0];
        int count = 1;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] == prevNum && count < 2) {
                nums[index++] = nums[i];
                count++;
            } else if(nums[i] != prevNum){
                count = 1;
                prevNum = nums[i];
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}

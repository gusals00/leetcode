package _2023년._9월.medium;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int cnt = 1;
        int index = 1;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                if(cnt < 2) {
                    nums[index++] = nums[i];
                }
                cnt++;
            } else {
                cnt = 1;
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}

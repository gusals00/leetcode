package _2023년._7월.medium;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int cnt = 1;
        int length = nums.length;
        if(length == 1) return 1;

        for(int i = 0; i< length-1; i++) {
            if(nums[i] != nums[i+1]) {
                if(cnt > 1) {
                    nums[index++] = nums[i];
                }
                nums[index++] = nums[i];
                cnt=1;
            } else {
                cnt++;
            }
        }

        if(length > 1) {
            if(cnt > 1) {
                nums[index++] = nums[length-1];
                nums[index++] = nums[length-1];
            } else if(nums[length-2] != nums[length-1]) {
                nums[index++] = nums[length-1];
            }
        }

        return index;
    }
}

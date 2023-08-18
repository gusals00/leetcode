package _2023년._8월.medium;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            int mid = (left+right) / 2;
            if(nums[mid] > nums[right]) {
                left = mid  + 1;
            }else if(nums[mid] < nums[right]) {
                right = mid;
            }
        }

        return nums[left];
    }
}

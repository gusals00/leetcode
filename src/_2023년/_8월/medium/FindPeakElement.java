package _2023년._8월.medium;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while(start < end) {
            int mid = (start + end) / 2;
            if(nums[mid] < nums[mid+1])
                start = mid+1;
            else
                end = mid;
        }

        return start;
    }
}

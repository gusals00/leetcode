package _2023년._10월.medium;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};

        int start = 0;
        int end = nums.length-1;

        int min = -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] < target) {
                start = mid + 1;
            } else if(target < nums[mid]) {
                end = mid - 1;
            } else {
                min = mid;
                end = mid-1;
            }
        }

        start = 0;
        end = nums.length-1;
        int max = -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] < target) {
                start = mid + 1;
            } else if(target < nums[mid]) {
                end = mid - 1;
            } else {
                max = mid;
                start = mid+1;
            }
        }

        result[0] = min;
        result[1] = max;
        return result;
    }
}

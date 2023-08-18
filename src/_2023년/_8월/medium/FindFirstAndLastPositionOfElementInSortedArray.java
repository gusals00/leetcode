package _2023년._8월.medium;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};

        int min = -1;
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = (left+right) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else if(target < nums[mid]) {
                right = mid - 1;
            } else {
                min = mid;
                right = mid - 1;
            }
        }
        result[0] = min;

        int max = -1;
        left = 0;
        right = nums.length-1;
        while(left <= right) {
            int mid = (left+right) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else if(target < nums[mid]) {
                right = mid - 1;
            } else {
                max = mid;
                left = mid + 1;
            }
        }
        result[1] = max;

        return result;
    }
}

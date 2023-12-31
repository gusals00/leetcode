package _2023년._12월.medium;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirstOrLast(nums, target, true);
        int last = findFirstOrLast(nums, target, false) -1;

        if(first >= nums.length || first > last) {
            return new int[]{-1,-1};
        }

        return new int[]{first, last};
    }

    private int findFirstOrLast(int[] nums, int target, boolean isFirst) {
        int start = 0;
        int end = nums.length-1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(target < nums[mid] || (isFirst && target == nums[mid])) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}

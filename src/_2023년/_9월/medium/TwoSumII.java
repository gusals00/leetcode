package _2023년._9월.medium;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;

        while(start < end) {
            int sum = numbers[start] + numbers[end];
            if(sum == target) {
                break;
            } else if(sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[]{start+1, end+1};
    }
}

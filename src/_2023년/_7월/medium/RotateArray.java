package _2023년._7월.medium;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        int[] tmp = new int[nums.length];

        for(int i=nums.length-k; i<nums.length; i++) {
            tmp[i-nums.length+k] = nums[i];
        }

        for(int i=nums.length-1; i>=k; i--) {
            nums[i] = nums[i-k];
        }

        for(int i=0; i<k; i++) {
            nums[i] = tmp[i];
        }
    }
}

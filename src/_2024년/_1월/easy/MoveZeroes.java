package _2024년._1월.easy;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while(index < nums.length) {
            nums[index++] = 0;
        }
    }
}

package _2024년._4월.medium;

public class SortColors {
    public void sortColors(int[] nums) {
        int index = 0;
        int red = 0;
        int blue = nums.length-1;

        while(index <= blue) {
            if(nums[index] == 2) {
                swap(nums, index, blue--);
            } else if(nums[index] == 0) {
                swap(nums, index++, red++);
            } else {
                index++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

package _2023년._11월.easy;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;

        for (int num : nums) {
            if(count == 0) {
                result = num;
            }

            if(result == num) {
                count++;
            } else {
                count--;
            }
        }

        return result;
    }
}

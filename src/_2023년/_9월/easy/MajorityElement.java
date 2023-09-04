package _2023년._9월.easy;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int result = 0;

        for(int n : nums) {
            if(count == 0) {
                result = n;
            }

            if(result == n) {
                count++;
            } else {
                count--;
            }
        }

        return result;
    }
}

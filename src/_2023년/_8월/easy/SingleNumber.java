package _2023년._8월.easy;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int n : nums) {
            result ^= n;
        }

        return result;
    }
}

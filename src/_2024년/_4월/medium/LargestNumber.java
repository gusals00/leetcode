package _2024년._4월.medium;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for(int i=0; i<nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, (s, s2) -> (s2+s).compareTo(s+s2));
        String result = String.join("", strings);

        if(result.isEmpty() || result.charAt(0) == '0') {
            return "0";
        }

        return result;
    }
}

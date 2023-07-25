package _2023년._7월.easy;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];

        int count = 0;
        int firstLength = first.length();
        for(int i = 0; firstLength > i && first.charAt(i)==last.charAt(i); i++) {
            count++;
        }

        return first.substring(0, count);
    }
}

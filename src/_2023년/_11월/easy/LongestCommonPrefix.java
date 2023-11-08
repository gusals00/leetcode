package _2023년._11월.easy;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length-1];
        int count = 0;

        for(int i=0; i<start.length() && start.charAt(i) == end.charAt(i); i++) {
            count++;
        }


        return start.substring(0, count);
    }
}

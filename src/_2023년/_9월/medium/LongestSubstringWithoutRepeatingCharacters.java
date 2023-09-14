package _2023년._9월.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int result = 0;

        for(int end = 0; end < s.length(); end++) {
            while(!set.add(s.charAt(end))) {
                set.remove(s.charAt(start++));
            }
            result = Math.max(result, end-start+1);
        }

        return result;
    }
}

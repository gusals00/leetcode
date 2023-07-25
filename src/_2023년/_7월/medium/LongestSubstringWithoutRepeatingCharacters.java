package _2023년._7월.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hset = new HashSet<>();
        int left = 0;
        int result = 0;

        for(int right = 0; right < s.length(); right++) {
            while(!hset.add(s.charAt(right))) {
                hset.remove(s.charAt(left++));
            }
            result = Math.max(result, right-left+1);
        }

        return result;
    }
}

package _2024년._1월.medium;

import java.util.Set;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int count = 0;

        for(int i=0; i<k; i++) {
            if(set.contains(chars[i])) {
                count++;
            }
        }

        int max = count;
        for(int i=k; i<chars.length; i++) {
            if(set.contains(chars[i])) {
                count++;
            }
            if(set.contains(chars[i-k])) {
                count--;
            }
            max = Math.max(max, count);
            if(max == k) {
                return max;
            }
        }

        return max;
    }
}

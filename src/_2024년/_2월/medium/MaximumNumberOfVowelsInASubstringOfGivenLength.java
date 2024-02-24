package _2024년._2월.medium;

import java.util.Set;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        Set<Character> vowel = Set.of('a', 'e', 'i', 'o', 'u');
        char[] chars = s.toCharArray();

        int count = 0;
        for(int i=0; i<k; i++) {
            if(vowel.contains(chars[i])) {
                count++;
            }
        }

        int max = count;
        for(int i=k; i<chars.length; i++) {
            if(vowel.contains(chars[i])) {
                count++;
            }
            if(vowel.contains(chars[i-k])) {
                count--;
            }

            max = Math.max(max, count);
            if(max == k) {
                return k;
            }
        }

        return max;
    }
}

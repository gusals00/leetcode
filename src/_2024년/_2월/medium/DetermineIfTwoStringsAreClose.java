package _2024년._2월.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) {
            return false;
        }

        int[] first = new int[26];
        int[] second = new int[26];
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i=0; i<word1.length(); i++) {
            first[word1.charAt(i)-'a']++;
            set.add(word1.charAt(i)-'a');
            second[word2.charAt(i)-'a']++;
            set2.add(word2.charAt(i)-'a');
        }

        if(!set.equals(set2)) {
            return false;
        }

        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }
}

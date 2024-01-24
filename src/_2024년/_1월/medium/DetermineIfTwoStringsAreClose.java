package _2024년._1월.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        int[] first = new int[26];
        int[] second = new int[26];
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();

        for (char c : word1.toCharArray()) {
            first[c-'a']++;
            firstSet.add(c-'a');
        }
        for (char c : word2.toCharArray()) {
            second[c-'a']++;
            secondSet.add(c-'a');
        }

        if(!firstSet.equals(secondSet)) {
            return false;
        }

        Arrays.sort(first);
        Arrays.sort(second);
        for(int i=0; i<26; i++) {
            if(first[i] != second[i]) {
                return false;
            }
        }
        return true;
    }
}

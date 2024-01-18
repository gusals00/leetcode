package _2024년._1월.easy;

import java.util.Set;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int start = 0;
        int end = s.length()-1;
        char[] chars = s.toCharArray();

        while(start < end) {
            while(start < end && !vowels.contains(chars[start])) {
                start++;
            }
            while(start < end && !vowels.contains(chars[end])) {
                end--;
            }

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }

        return String.valueOf(chars);
    }
}

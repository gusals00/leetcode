package _2023년._9월.medium;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for(int i=split.length-1; i>0; i--) {
            result.append(split[i] + " ");
        }

        return result.toString() + split[0];
    }
}

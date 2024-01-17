package _2024년._1월.easy;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int word1Index = 0;
        int word2Index = 0;

        while(word1Index < word1.length() || word2Index < word2.length()) {
            if(word1Index < word1.length()) {
                sb.append(word1.charAt(word1Index++));
            }
            if(word2Index < word2.length()) {
                sb.append(word2.charAt(word2Index++));
            }
        }

        return sb.toString();
    }
}

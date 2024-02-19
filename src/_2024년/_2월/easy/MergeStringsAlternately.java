package _2024년._2월.easy;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int n = word1.length();
        int m = word2.length();

        int index = 0;
        while (index < n && index < m) {
            result.append(word1.charAt(index)).append(word2.charAt(index));
            index++;
        }
        if(index < n) {
            result.append(word1.substring(index, n));
        } else {
            result.append(word2.substring(index, m));
        }
        return result.toString();
    }
}

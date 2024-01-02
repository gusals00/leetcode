package _2024년._1월.medium;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i=1; i<=s.length(); i++) {
            for (String word : wordDict) {
                int beginIndex = i - word.length();
                if(beginIndex >= 0 && dp[beginIndex] && s.substring(beginIndex, i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}

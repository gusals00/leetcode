package _2023년._10월.medium;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i=1; i<=s.length(); i++) {
            for (String word : wordDict) {
                int length = word.length();
                if(i-length >= 0) {
                    if(dp[i-length] && s.substring(i-length, i).equals(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[dp.length-1];
    }
}

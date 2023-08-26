package _2023년._8월.medium;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i=1; i<=s.length(); i++) {
            for(String str : wordDict) {
                int len = str.length();
                if(i-len >= 0) {
                    if(dp[i-len] && s.substring(i-len, i).equals(str)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[dp.length-1];
    }
}

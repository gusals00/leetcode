package _2024년._5월.programmers.lv2;

import java.util.HashSet;
import java.util.Set;

public class 연속_부분_수열_합의_개수 {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] dp = new int[elements.length];
        for(int i=0; i<elements.length; i++) {
            dp[i] = elements[i];
            set.add(elements[i]);
        }

        for(int i=1; i<elements.length; i++) {
            for(int j=0; j<dp.length; j++) {
                int index = (i+j) % elements.length;
                dp[j] += elements[index];
                set.add(dp[j]);
            }
        }

        return set.size();
    }
}

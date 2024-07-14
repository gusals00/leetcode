package _2024년._7월.programmers.lv2;

import java.util.HashSet;
import java.util.Set;

public class 소수_찾기 {
    public int solution(String numbers) {
        char[] chars = numbers.toCharArray();
        int result = 0;
        Set<Integer> set = new HashSet<>();

        dfs(chars, new StringBuilder(), set, new boolean[chars.length]);

        for (int i : set) {
            if(isPrimeNumber(i)) {
                result++;
            }
        }

        return result;
    }

    private void dfs(char[] chars, StringBuilder sb, Set<Integer> set, boolean[] visited) {
        if(sb.length() != 0) {
            set.add(Integer.parseInt(sb.toString()));
        }

        for(int i=0; i<chars.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sb.append(chars[i]);
                dfs(chars, sb, set, visited);
                sb.deleteCharAt(sb.length()-1);
                visited[i] = false;
            }
        }
    }

    private boolean isPrimeNumber(int value) {
        if(value < 2) {
            return false;
        }

        for(int i=2; i<=Math.sqrt(value); i++) {
            if(value%i == 0) {
                return false;
            }
        }

        return true;
    }
}

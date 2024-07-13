package _2024년._7월.programmers.lv3;

public class 단어_변환 {
    private int result = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        dfs(begin, target, words, new boolean[words.length], 0);

        if(result == Integer.MAX_VALUE) {
            return 0;
        } else {
            return result;
        }
    }

    private void dfs(String begin, String target, String[] words, boolean[] visited, int count) {
        if(begin.equals(target)) {
            result = Math.min(count, result);
            return;
        }

        for(int i=0; i<words.length; i++) {
            if(!visited[i]) {
                int notEqual = 0;
                String word = words[i];

                for(int j=0; j<target.length(); j++) {
                    if(word.charAt(j) != begin.charAt(j)) {
                        notEqual++;
                    }
                }

                if(notEqual == 1) {
                    visited[i] = true;
                    dfs(word, target, words, visited, count+1);
                    visited[i] = false;
                }
            }
        }
    }
}

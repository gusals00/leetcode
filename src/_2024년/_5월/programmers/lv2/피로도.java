package _2024년._5월.programmers.lv2;

public class 피로도 {
    int result = 0;
    public int solution(int k, int[][] dungeons) {
        dfs(k, dungeons, new boolean[dungeons.length], 0);

        return result;
    }

    private void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, visited, count+1);
                visited[i] = false;
            }
        }

        result = Math.max(result, count);
    }
}

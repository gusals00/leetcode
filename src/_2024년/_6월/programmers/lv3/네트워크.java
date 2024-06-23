package _2024년._6월.programmers.lv3;

public class 네트워크 {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int result = 0;

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(computers, n, i, visited);
                result++;
            }
        }

        return result;
    }

    private void dfs(int[][] computers, int n, int index, boolean[] visited) {
        for(int i=0; i<n; i++) {
            if(!visited[i] && computers[index][i] == 1) {
                visited[i] = true;
                dfs(computers, n, i, visited);
            }
        }
    }
}

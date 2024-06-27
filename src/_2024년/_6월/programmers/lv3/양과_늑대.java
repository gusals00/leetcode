package _2024년._6월.programmers.lv3;

public class 양과_늑대 {
    int result = 0;
    public int solution(int[] info, int[][] edges) {
        dfs(info, edges, new boolean[info.length], 0, 0, 0);

        return result;
    }

    private void dfs(int[] info, int[][] edges, boolean[] visited, int index, int sheep, int wolf) {
        visited[index] = true;

        if(info[index] == 0) {
            sheep++;
            result = Math.max(result, sheep);
        } else {
            wolf++;
            if (wolf >= sheep) {
                return;
            }
        }

        for (int[] edge : edges) {
            if(visited[edge[0]] && !visited[edge[1]]) {
                dfs(info, edges, visited.clone(), edge[1], sheep, wolf);
            }
        }
    }
}

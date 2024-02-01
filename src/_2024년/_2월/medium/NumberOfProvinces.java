package _2024년._2월.medium;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i=0; i<n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(isConnected, visited, i);
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        for(int i=0; i<isConnected.length; i++) {
            if(!visited[i] && isConnected[city][i] == 1) {
                visited[i] = true;
                dfs(isConnected, visited, i);
            }
        }
    }
}

package _2024년._3월.medium;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int province = 0;

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                province++;
                dfs(isConnected, i, visited);
            }
        }

        return province;
    }

    private void dfs(int[][] isConnected, int city, boolean[] visited) {
        visited[city] = true;

        for(int i=0; i<isConnected.length; i++) {
            if(isConnected[city][i] == 1 && !visited[i]) {
                dfs(isConnected, i, visited);
            }
        }
    }
}

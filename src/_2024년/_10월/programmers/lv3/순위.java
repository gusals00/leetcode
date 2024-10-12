package _2024년._10월.programmers.lv3;

public class 순위 {
    public int solution(int n, int[][] results) {
        int result = 0;
        int[][] graph = new int[n+1][n+1];
        for (int[] r : results) {
            graph[r[0]][r[1]] = 1;
        }

        for(int i=1; i<graph.length; i++) {
            for(int j=1; j<graph.length; j++) {
                for(int k=1; k<graph.length; k++) {
                    if(graph[j][i] == 1 && graph[i][k] == 1) {
                        graph[j][k] = 1;
                    }
                }
            }
        }

        for(int i=1; i<graph.length; i++) {
            int count = 0;
            for(int j=1; j<graph.length; j++) {
                if(graph[i][j] == 1 || graph[j][i] == 1) {
                    count++;
                }
            }

            if(count == n-1) {
                result++;
            }
        }

        return result;
    }
}

package _2024년._5월.programmers.lv2;

public class 쿼드압축_후_개수_세기 {
    private int zeroCount = 0;
    private int oneCount = 0;
    public int[] solution(int[][] arr) {
        int n = arr.length;

        dfs(arr, 0, 0, n);

        return new int[]{zeroCount, oneCount};
    }

    private void dfs(int[][] arr, int x, int y, int size) {
        if(size == 0) {
            return;
        }
        if(check(arr, x, y, size)) {
            if(arr[x][y] == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }

            return;
        }

        int nextSize = size / 2;
        dfs(arr, x, y, nextSize);
        dfs(arr, x + nextSize, y, nextSize);
        dfs(arr, x, y + nextSize, nextSize);
        dfs(arr, x + nextSize, y + nextSize, nextSize);
    }

    private boolean check(int[][] arr, int x, int y, int size) {
        int check = arr[x][y];
        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(check != arr[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}

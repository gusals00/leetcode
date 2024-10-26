package _2024년._10월.programmers.lv2;

public class N_Queen {
    private int count = 0;

    public int solution(int n) {
        int[] arr = new int[n];

        dfs(arr, n, 0);

        return count;
    }

    private void dfs(int[] arr, int n, int depth) {
        if(depth == n) {
            count++;
            return;
        }

        for(int i=0; i<n; i++) {
            arr[depth] = i;
            if(isPossible(arr, depth)) {
                dfs(arr, n, depth+1);
            }
        }
    }

    private boolean isPossible(int[] arr, int depth) {
        for(int i=0; i<depth; i++) {
            if (arr[i] == arr[depth]) {
                return false;
            }

            if(Math.abs(depth - i) == Math.abs(arr[i] - arr[depth])) {
                return false;
            }
        }

        return true;
    }
}

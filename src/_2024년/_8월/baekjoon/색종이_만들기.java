package _2024년._8월.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_만들기 {
    private static int blue = 0;
    private static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(arr, 0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void dfs(int[][] arr, int x, int y, int size) {
        if(isSame(arr, x, y, size)) {
            if(arr[x][y] == 0) {
                white++;
            } else {
                blue++;
            }

            return;
        }

        dfs(arr, x, y, size/2);
        dfs(arr, x+size/2, y, size/2);
        dfs(arr, x, y+size/2, size/2);
        dfs(arr, x+size/2, y+size/2, size/2);
    }

    private static boolean isSame(int[][] arr, int x, int y, int size) {
        int value = arr[x][y];
        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(arr[i][j] != value) {
                    return false;
                }
            }
        }

        return true;
    }
}

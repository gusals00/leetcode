package _2024년._8월.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무_자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int low = 0;
        int high = arr[arr.length-1];

        while(low + 1 < high) {
            int mid = (low + high) / 2;
            if(check(arr, mid, m)) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.println(low);
    }

    private static boolean check(int[] arr, int mid, int m) {
        long wood = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > mid) {
                wood += arr[i] - mid;
            }
        }

        return wood >= m;
    }
}

package _2024년._8월.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 과일_탕후루 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] fruit = new int[10];
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int low = 0;
        int high = 0;
        int kind = 0;
        while(high < n) {
            fruit[arr[high]]++;
            if(fruit[arr[high]] == 1) {
                kind++;
            }

            while(kind > 2) {
                fruit[arr[low]]--;
                if(fruit[arr[low]] == 0) {
                    kind--;
                }

                low++;
            }

            result = Math.max(result, high-low+1);
            high++;
        }

        System.out.println(result);
    }
}

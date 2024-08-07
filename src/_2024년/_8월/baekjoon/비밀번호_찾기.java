package _2024년._8월.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 비밀번호_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Map<String, String> map = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        for(int i=0; i<m; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }
}

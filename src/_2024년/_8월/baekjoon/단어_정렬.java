package _2024년._8월.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단어_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> sets = new HashSet<>();
        for(int i=0; i<n; i++) {
            sets.add(br.readLine());
        }
        List<String> list = new ArrayList<>(sets);

        Collections.sort(list, (a, b) -> {
            if(a.length() == b.length()) {
                return a.compareTo(b);
            }

            return a.length()-b.length();
        });

        for (String s : list) {
            System.out.println(s);
        }
    }
}

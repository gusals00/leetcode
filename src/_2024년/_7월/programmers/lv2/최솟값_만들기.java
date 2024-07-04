package _2024년._7월.programmers.lv2;

import java.util.Arrays;

public class 최솟값_만들기 {
    public int solution(int[] A, int[] B) {
        int result = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length; i++) {
            result += A[i] * B[A.length-i-1];
        }
        return result;
    }
}

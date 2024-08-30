package _2024년._8월.programmers.lv1;

public class 덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int end = section[0] + m - 1;
        int result = 1;

        for(int i=0; i<section.length; i++) {
            if(end < section[i]) {
                end = section[i] + m - 1;
                result++;
            }
        }

        return result;
    }
}

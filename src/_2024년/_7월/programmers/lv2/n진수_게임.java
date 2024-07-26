package _2024년._7월.programmers.lv2;

public class n진수_게임 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for(int i=0; sb.length() <= t*m; i++) {
            sb.append(Integer.toString(i, n).toUpperCase());
        }
        for(int i=p-1; i<t*m; i+=m) {
            result.append(sb.charAt(i));
        }

        return result.toString();
    }
}

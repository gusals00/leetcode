package _2024년._9월.programmers.lv1;

public class 숫자_짝꿍 {
    public String solution(String X, String Y) {
        int[] xCount = new int[10];
        int[] yCount = new int[10];

        for (char c : X.toCharArray()) {
            xCount[c-'0']++;
        }
        for (char c : Y.toCharArray()) {
            yCount[c-'0']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            int min = Math.min(xCount[i], yCount[i]);
            if(min != 0) {
                sb.append(String.valueOf(i).repeat(min));
            }
        }

        if(sb.length() == 0) {
            return "-1";
        } else if(sb.charAt(0) == '0') {
            return "0";
        } else {
            return sb.toString();
        }
    }
}

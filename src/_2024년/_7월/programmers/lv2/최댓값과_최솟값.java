package _2024년._7월.programmers.lv2;

public class 최댓값과_최솟값 {
    public String solution(String s) {
        String[] strings = s.split(" ");

        int max = Integer.parseInt(strings[0]);
        int min = Integer.parseInt(strings[0]);

        for(int i=1; i<strings.length; i++) {
            int value = Integer.parseInt(strings[i]);
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        return min + " " + max;
    }
}

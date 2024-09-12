package _2024년._9월.programmers.lv1;

public class 문자열_나누기 {
    public int solution(String s) {
        int result = 0;
        int index = 0;
        while(index < s.length()) {
            char c = s.charAt(index++);
            int same = 1;
            int other = 0;

            while(index < s.length() &&  same != other) {
                if(s.charAt(index) == c) {
                    same++;
                } else {
                    other++;
                }
                index++;
            }

            result++;
        }

        return result;
    }
}

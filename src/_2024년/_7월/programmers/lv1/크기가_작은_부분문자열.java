package _2024년._7월.programmers.lv1;

public class 크기가_작은_부분문자열 {
    public int solution(String t, String p) {
        int result = 0;
        int length = p.length();
        long value = Long.parseLong(p);

        for(int i=0; i<=t.length()-length; i++) {
            if(Long.parseLong(t.substring(i, i+length)) <= value) {
                result++;
            }
        }

        return result;
    }
}

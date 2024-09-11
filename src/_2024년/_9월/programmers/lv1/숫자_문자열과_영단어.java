package _2024년._9월.programmers.lv1;

public class 숫자_문자열과_영단어 {
    public int solution(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0; i<numbers.length; i++) {
            if(s.contains(numbers[i])) {
                s = s.replaceAll(numbers[i], String.valueOf(i));
            }
        }

        return Integer.parseInt(s);
    }
}

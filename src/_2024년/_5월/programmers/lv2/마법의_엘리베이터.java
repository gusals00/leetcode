package _2024년._5월.programmers.lv2;

public class 마법의_엘리베이터 {
    public int solution(int storey) {
        char[] chars = String.valueOf(storey).toCharArray();
        int result = 0;

        for(int i=chars.length-1; i>=0; i--) {
            int num = chars[i] - '0';

            if(num > 5) {
                result += 10 - num;

                if(i == 0)
                    result++;
                else
                    chars[i-1]++;
            } else if(num == 5 && i>0 && chars[i-1]-'0' > 4) {
                result += 5;
                chars[i-1]++;
            } else {
                result += num;
            }
        }

        return result;
    }
}

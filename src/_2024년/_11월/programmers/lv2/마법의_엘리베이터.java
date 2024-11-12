package _2024년._11월.programmers.lv2;

public class 마법의_엘리베이터 {
    public int solution(int storey) {
        int result = 0;
        
        while(storey > 0) {
            int num = storey % 10;
            storey /= 10;
            
            if(num == 5) {
                if(storey % 10 > 4) {
                    result += (10 - num);
                    storey++;
                } else {
                    result += num;
                }
            } else if(num > 5) {
                result += (10 - num);
                storey++;
            } else {
                result += num;
            }
        }

        return result;
    }
}

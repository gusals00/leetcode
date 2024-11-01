package _2024년._11월.programmers.lv1;

import java.util.Set;

public class 옹알이_2 {
    public int solution(String[] babbling) {
        int result = 0;
        Set<String> set = Set.of("aya", "ye", "woo", "ma");

        for(String s : babbling) {
            String before = "";
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<s.length(); i++) {
                sb.append(s.charAt(i));

                if(set.contains(sb.toString())) {
                    if(before.equals(sb.toString())) {
                        break;
                    }

                    before = sb.toString();
                    sb.setLength(0);
                }
            }

            if(sb.length() == 0) {
                result++;
            }
        }

        return result;
    }
}

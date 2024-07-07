package _2024년._7월.programmers.lv2;

import java.util.HashSet;
import java.util.Set;

public class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] result = {0,0};
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        char prevChar = words[0].charAt(words[0].length()-1);

        for(int i=1; i<words.length; i++) {
            String word = words[i];
            if(set.contains(word) || word.charAt(0) != prevChar) {
                result[0] = i%n + 1;
                result[1] = i/n + 1;
                return result;
            }

            set.add(word);
            prevChar = word.charAt(word.length()-1);
        }

        return result;
    }
}

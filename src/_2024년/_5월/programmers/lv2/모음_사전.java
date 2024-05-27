package _2024년._5월.programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class 모음_사전 {
    Character[] alphabet = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        List<String> list = new ArrayList<>();

        dfs(list, new StringBuilder(), 0);

        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(word)) {
                return i;
            }
        }

        return -1;
    }

    private void dfs(List<String> list, StringBuilder sb, int index) {
        list.add(sb.toString());
        if(index == 5) {
            return;
        }

        for(int i=0; i<alphabet.length; i++) {
            sb.append(alphabet[i]);
            dfs(list, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

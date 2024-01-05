package _2024년._1월.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()) {
            return result;
        }

        dfs(digits, letters, 0, result, new StringBuilder());
        return result;
    }

    private void dfs(String digits, String[] letters, int index, List<String> list, StringBuilder sb) {
        if(index == digits.length()) {
            list.add(sb.toString());
            return;
        }

        String letter = letters[digits.charAt(index)-'0'];
        for(int i=0; i<letter.length(); i++) {
            sb.append(letter.charAt(i));
            dfs(digits, letters, index+1, list, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

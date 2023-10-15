package _2023년._10월.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] number = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if(digits.length() == 0)
            return result;

        dfs(digits, number, 0, new StringBuilder(), result);
        return result;
    }

    private void dfs(String digits, String[] number, int index, StringBuilder sb, List<String> result) {
        if (digits.length() == index) {
            result.add(sb.toString());
            return;
        }

        String s = number[digits.charAt(index)-'0'];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs(digits, number, index+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

package _2023년._8월.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    private String[] numbers = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) {
            return result;
        }
        backtracking(digits, result, new StringBuilder(), 0);
        return result;
    }

    private void backtracking(String digits, List<String> result, StringBuilder sb, int index) {
        if(digits.length() == index) {
            result.add(sb.toString());
            return;
        }

        String number = numbers[digits.charAt(index) - '0' - 2];
        for(int i=0; i<number.length(); i++) {
            sb.append(number.charAt(i));
            backtracking(digits, result, sb, index+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

package _2023년._11월.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void generateParenthesis(int n, int left, int right, StringBuilder sb, List<String> result) {
        if(left > n || right > n) {
            return;
        } else if(left == n && right == n) {
            result.add(sb.toString());
            return;
        }

        if(left < n) {
            sb.append("(");
            generateParenthesis(n, left+1, right, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right < n && right < left) {
            sb.append(")");
            generateParenthesis(n, left, right+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

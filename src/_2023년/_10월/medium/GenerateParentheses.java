package _2023년._10월.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, 0, 0, result, new StringBuilder());

        return result;
    }

    private void generateParenthesis(int n, int left, int right, List<String> result, StringBuilder sb) {
        if(left > n || right > n)
            return;
        else if(left == n && right == n) {
            result.add(sb.toString());
            return;
        }

        if(left < n) {
            sb.append("(");
            generateParenthesis(n, left+1, right, result, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right < n && right < left) {
            sb.append(")");
            generateParenthesis(n, left, right+1, result, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

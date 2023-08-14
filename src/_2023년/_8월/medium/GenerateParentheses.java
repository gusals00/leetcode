package _2023년._8월.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recur(result, n, n, new StringBuilder());
        return result;
    }

    private void recur(List<String> result, int left, int right, StringBuilder sb) {
        if(left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        } else if(left < 0 || right < 0) {
            return;
        }

        if(left > 0) {
            sb.append('(');
            recur(result, left-1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right > 0 && left < right) {
            sb.append(')');
            recur(result, left, right - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

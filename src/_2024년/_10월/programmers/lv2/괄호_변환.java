package _2024년._10월.programmers.lv2;

public class 괄호_변환 {
    public String solution(String p) {
        if(p.isBlank()) {
            return p;
        }

        int leftCount = 0;
        int rightCount = 0;
        int index = 0;
        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }

            if(leftCount == rightCount) {
                index = i;
                break;
            }
        }

        String u = p.substring(0, index+1);
        String v = p.substring(index+1);

        if(isCorrectString(u)) {
            return u + solution(v);
        }

        return "(" + solution(v) + ")" + reverseString(u);
    }

    private String reverseString(String u) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<u.length()-1; i++) {
            if(u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }

        return sb.toString();
    }

    private boolean isCorrectString(String u) {
        int leftCount = 0;
        int rightCount = 0;
        for(int i=0; i<u.length(); i++) {
            if(u.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }

            if(rightCount > leftCount) {
                return false;
            }
        }

        return true;
    }
}

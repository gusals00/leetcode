package _2024년._7월.programmers.lv2;

public class JadenCase_문자열_만들기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strings = s.split(" ");

        for (String string : strings) {
            if(string.length() == 0) {
                sb.append(" ");
            } else {
                sb.append(Character.toUpperCase(string.charAt(0)));
                sb.append(string.substring(1).toLowerCase());
                sb.append(" ");
            }
        }

        if(s.charAt(s.length()-1) == ' ') {
            return sb.toString();
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}

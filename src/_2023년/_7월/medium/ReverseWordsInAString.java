package _2023년._7월.medium;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] strings = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(int i=strings.length-1; i>=0; i--) {
            sb.append(strings[i]);

            if(i-1 >= 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}

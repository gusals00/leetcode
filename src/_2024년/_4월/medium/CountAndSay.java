package _2024년._4월.medium;

public class CountAndSay {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }

        String s = countAndSay(n - 1);
        int length = s.length();
        StringBuilder sb = new StringBuilder();

        int index = 0;
        while(index < length) {
            int count = 1;

            while(index + 1 < length && s.charAt(index) == s.charAt(index+1)) {
                index++;
                count++;
            }

            sb.append(count).append(s.charAt(index));
            index++;
        }

        return sb.toString();
    }
}

package _2024년._1월.medium;

public class StringCompression {
    public int compress(char[] chars) {
        int index = 0;

        for(int i=0; i<chars.length; i++) {
            char c = chars[i];
            int count = 1;
            while(i+1 < chars.length && c == chars[i+1]) {
                i++;
                count++;
            }

            chars[index++] = c;

            if(count > 1) {
                for (char num : String.valueOf(count).toCharArray()) {
                    chars[index++] = num;
                }
            }
        }

        return index;
    }
}

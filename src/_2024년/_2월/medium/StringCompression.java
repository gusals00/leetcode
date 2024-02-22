package _2024년._2월.medium;

public class StringCompression {
    public int compress(char[] chars) {
        int index = 0;

        for(int i=0; i<chars.length; i++) {
            char c = chars[i];
            int count = 1;
            while(i+1 < chars.length && chars[i+1] == c) {
                i++;
                count++;
            }

            chars[index++] = c;
            if(count > 1) {
                for (char value : String.valueOf(count).toCharArray()) {
                    chars[index++] = value;
                }
            }
        }

        return index;
    }
}

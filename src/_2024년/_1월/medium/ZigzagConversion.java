package _2024년._1월.medium;

import java.util.Arrays;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0; i<sb.length; i++) {
            sb[i] = new StringBuilder();
        }

        int cycle = (numRows-1) * 2;
        for(int i=0; i<s.length(); i++) {
            int num = i % cycle;
            int row = num < numRows ? num : cycle-num;
            sb[row].append(s.charAt(i));
        }

        return Arrays.stream(sb).reduce(StringBuilder::append).get().toString();
    }
}

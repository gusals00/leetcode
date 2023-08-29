package _2023년._8월.medium;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;

        StringBuilder[] builders = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++) {
            builders[i] = new StringBuilder();
        }

        int k = (numRows - 1) * 2;
        for(int i=0; i<s.length(); i++) {
            int rest = i % k;
            int row = rest < numRows ? rest : k - rest;
            builders[row].append(s.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder sb : builders) {
            result.append(sb);
        }

        return result.toString();
    }
}

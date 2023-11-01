package _2023년._11월.medium;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0; i<sb.length; i++) {
            sb[i] = new StringBuilder();
        }

        int cycle = (numRows - 1) * 2;
        for (int i = 0; i < s.length(); i++) {
            int rest = i % cycle;
            int row = rest < numRows ? rest : cycle-rest;
            sb[row].append(s.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : sb) {
            result.append(stringBuilder);
        }

        return result.toString();
    }
}

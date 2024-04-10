package _2024년._4월.easy;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (char c : columnTitle.toCharArray()) {
            result *= 26;
            result += c - 'A' + 1;
        }

        return result;
    }
}

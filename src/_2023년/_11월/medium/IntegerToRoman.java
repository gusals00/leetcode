package _2023년._11월.medium;

public class IntegerToRoman {
    public String intToRoman(int num) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();
        int index = 0;
        while(num > 0) {
            int count = num / values[index];
            num %= values[index];
            result.append(romans[index].repeat(count));

            index++;
        }

        return result.toString();
    }
}

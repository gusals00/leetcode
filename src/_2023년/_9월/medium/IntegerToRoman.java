package _2023년._9월.medium;

public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        int i = 0;
        while(num > 0) {
            while(num >= values[i]) {
                int cnt = num/values[i];
                num %= values[i];
                result.append(roman[i].repeat(cnt));
            }
            i++;
        }

        return result.toString();
    }
}

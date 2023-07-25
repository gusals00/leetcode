package _2023년._7월.easy;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length-1].length();
    }
}

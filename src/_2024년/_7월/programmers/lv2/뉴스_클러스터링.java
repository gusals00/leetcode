package _2024년._7월.programmers.lv2;

import java.util.*;

public class 뉴스_클러스터링 {
    public int solution(String str1, String str2) {
        List<String> set1 = new ArrayList<>();
        List<String> set2 = new ArrayList<>();
        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for(int i=0; i<str1.length()-1; i++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);

            if(Character.isLetter(first) && Character.isLetter(second)) {
                set1.add(first + "" + second);
            }
        }
        for(int i=0; i<str2.length()-1; i++) {
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);

            if(Character.isLetter(first) && Character.isLetter(second)) {
                set2.add(first + "" + second);
            }
        }

        for (String s : set1) {
            if(set2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        union.addAll(set2);

        double result;
        if(union.size() == 0) {
            result = 1;
        } else {
            result = (double)intersection.size() / (double)union.size();
        }

        return (int)(result*65536);
    }
}

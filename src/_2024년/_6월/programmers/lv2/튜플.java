package _2024년._6월.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 튜플 {
    public int[] solution(String s) {
        s = s.substring(2, s.length()-2).replace("},{", "-");
        String[] split = s.split("-");

        Arrays.sort(split, Comparator.comparingInt(String::length));

        List<Integer> list = new ArrayList<>();
        for (String str : split) {
            String[] check = str.split(",");

            for(int i=0; i<check.length; i++) {
                int num = Integer.parseInt(check[i]);

                if(!list.contains(num)) {
                    list.add(num);
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

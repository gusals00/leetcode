package _2023년._7월.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IntegerToRoman {
    public String intToRoman(int num) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "I");
        hashMap.put(4, "IV");
        hashMap.put(5, "V");
        hashMap.put(9, "IX");
        hashMap.put(10, "X");
        hashMap.put(40, "XL");
        hashMap.put(50, "L");
        hashMap.put(90, "XC");
        hashMap.put(100, "C");
        hashMap.put(400, "CD");
        hashMap.put(500, "D");
        hashMap.put(900, "CM");
        hashMap.put(1000, "M");

        Set<Integer> integers = hashMap.keySet();
        List<Integer> collect = integers.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for(int key : collect) {
            int cnt = num / key;
            if(cnt > 0) {
                num %= key;
                sb.append(hashMap.get(key).repeat(cnt));
            }

            if(num <= 0) {
                break;
            }
        }

        return sb.toString();
    }
}

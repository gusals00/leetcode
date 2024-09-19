package _2024년._9월.programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class 햄버거_만들기 {
    public int solution(int[] ingredient) {
        int count = 0;
        List<Integer> list = new ArrayList<>();

        for (int i : ingredient) {
            list.add(i);

            if(list.size() >= 4) {
                if(list.get(list.size()-1) == 1 && list.get(list.size()-2) == 3
                && list.get(list.size()-3) == 2 && list.get(list.size()-4) == 1) {
                    for(int j=0; j<4; j++) {
                        list.remove(list.size()-1);
                    }
                    count++;
                }
            }
        }

        return count;
    }
}

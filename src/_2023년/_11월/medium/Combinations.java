package _2023년._11월.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(n, k, 1, new ArrayList<>(), result);

        return result;
    }

    private void combine(int n, int k, int index, List<Integer> list, List<List<Integer>> result) {
        if(list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=index; i<=n; i++) {
            list.add(i);
            combine(n, k, i+1, list, result);
            list.remove(list.size()-1);
        }
    }
}

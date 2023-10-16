package _2023년._10월.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(n, k, 1, result, new ArrayList<>());

        return result;
    }

    private void combine(int n, int k, int index, List<List<Integer>> result, List<Integer> list) {
        if (k == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n; i++) {
            list.add(i);
            combine(n, k, i+1, result, list);
            list.remove(list.size()-1);
        }
    }
}

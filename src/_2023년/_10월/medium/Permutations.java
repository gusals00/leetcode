package _2023년._10월.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permute(nums, result, new ArrayList<>(), visited);

        return result;
    }

    private void permute(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] visited) {
        if (nums.length == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(visited[i])
                continue;

            list.add(nums[i]);
            visited[i] = true;
            permute(nums, result, list, visited);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}

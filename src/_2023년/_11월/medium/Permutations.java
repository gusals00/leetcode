package _2023년._11월.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permute(nums, visited, new ArrayList<>(), result);

        return result;
    }

    private void permute(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
        if(nums.length == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            permute(nums, visited, list, result);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
}

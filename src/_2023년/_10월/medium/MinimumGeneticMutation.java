package _2023년._10월.medium;

import java.util.*;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> visited = new HashSet<>();
        List<String> bankList = Arrays.asList(bank);
        Queue<String> queue = new ArrayDeque<>();
        char[] gene = {'A', 'C', 'G', 'T'};
        int result = 0;

        queue.add(startGene);
        visited.add(startGene);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                StringBuilder sb = new StringBuilder(queue.remove());
                if(sb.toString().equals(endGene))
                    return result;

                for(int j=0; j<8; j++) {
                    char c = sb.charAt(j);

                    for(int k=0; k<4; k++) {
                        sb.setCharAt(j, gene[k]);
                        String str = sb.toString();
                        if(!visited.contains(str) && bankList.contains(str)) {
                            visited.add(str);
                            queue.add(str);
                        }
                    }

                    sb.setCharAt(j, c);
                }
            }
            result++;
        }

        return -1;
    }
}

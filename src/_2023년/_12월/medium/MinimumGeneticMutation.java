package _2023년._12월.medium;

import java.util.*;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        Set<String> banks = new HashSet<>();
        for (String s : bank) {
            banks.add(s);
        }
        char[] gene = {'A', 'C', 'G', 'T'};
        int result = 0;

        queue.add(startGene);
        visited.add(startGene);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                String remove = queue.remove();
                if(remove.equals(endGene)) {
                    return result;
                }
                visited.add(remove);

                StringBuilder sb = new StringBuilder(remove);
                for(int j=0; j<8; j++) {
                    char temp = sb.charAt(j);
                    for(int k=0; k<4; k++) {
                        sb.setCharAt(j, gene[k]);
                        String s = sb.toString();
                        if(!visited.contains(s) && banks.contains(s)) {
                            queue.add(s);
                        }
                    }
                    sb.setCharAt(j, temp);
                }
            }
            result++;
        }
        return -1;
    }
}

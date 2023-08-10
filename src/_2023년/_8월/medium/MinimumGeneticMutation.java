package _2023년._8월.medium;

import java.util.*;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        List<String> banks = Arrays.asList(bank);
        char[] gene = {'A','C','G','T'};

        int cnt = 0;
        queue.add(startGene);
        visited.add(startGene);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                String poll = queue.poll();
                if(poll.equals(endGene))
                    return cnt;

                char[] chars = poll.toCharArray();
                for(int j=0; j<8; j++) {
                    char tmp = chars[j];

                    for(int k=0; k<4; k++) {
                        chars[j] = gene[k];
                        String s = new String(chars);
                        if(!visited.contains(s) && banks.contains(s)) {
                            queue.add(s);
                            visited.add(s);
                        }
                    }
                    chars[j] = tmp;
                }
            }
            cnt++;
        }
        return -1;
    }
}

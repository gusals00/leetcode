package _2024년._10월.programmers.lv3;

import java.util.ArrayList;
import java.util.List;

public class 표_병합 {
    public String[] solution(String[] commands) {
        List<String> result = new ArrayList<>();
        int[] parents = new int[2501];
        String[] values = new String[2501];

        for(int i=1; i<=2500; i++) {
            parents[i] = i;
            values[i] = "";
        }

        for (String command : commands) {
            String[] split = command.split(" ");

            if("UPDATE".equals(split[0])) {
                if(split.length >= 4) {
                    int find = find(parents, getIndex(Integer.parseInt(split[1]), Integer.parseInt(split[2])));
                    values[find] = split[3];
                } else {
                    String value = split[1];
                    String next = split[2];
                    for(int i=1; i<parents.length; i++) {
                        if(values[i].equals(value)) {
                            values[i] = next;
                        }
                    }
                }
            } else if("MERGE".equals(split[0])) {
                int a = find(parents, getIndex(Integer.parseInt(split[1]), Integer.parseInt(split[2])));
                int b = find(parents, getIndex(Integer.parseInt(split[3]), Integer.parseInt(split[4])));

                String value = values[a].isBlank() ? values[b] : values[a];
                values[a] = "";
                values[b] = "";

                union(parents, a, b);
                values[a] = value;
            } else if("UNMERGE".equals(split[0])) {
                for(int i=1; i<parents.length; i++) {
                    find(parents, i);
                }

                int num = getIndex(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                int index = find(parents, num);
                String value = values[index];
                for(int i=1; i<parents.length; i++) {
                    if(parents[i] == index) {
                        parents[i] = i;
                        values[i] = "";
                    }
                }
                values[num] = value;
            } else {
                int index = find(parents, getIndex(Integer.parseInt(split[1]), Integer.parseInt(split[2])));
                String value = values[index];

                if("".equals(value)) {
                    result.add("EMPTY");
                } else {
                    result.add(value);
                }
            }
        }

        return result.toArray(new String[0]);
    }

    private int getIndex(int r, int c) {
        return (r-1)*50 + c;
    }

    private int find(int[] parents, int x) {
        if(parents[x] != x) {
            return parents[x] = find(parents, parents[x]);
        }

        return parents[x];
    }

    private void union(int[] parents, int a, int b) {
        a = find(parents, a);
        b = find(parents, b);

        if(a != b) {
            parents[b] = a;
        }
    }
}

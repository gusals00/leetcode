package _2024년._1월.medium;

import java.util.*;

public class EvaluateDivision {
    Map<String, Map<String, Double>> graph = new HashMap<>();
    Set<String> set = new HashSet<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        for(int i=0; i<equations.size(); i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);

            graph.putIfAbsent(first, new HashMap<>());
            graph.putIfAbsent(second, new HashMap<>());

            graph.get(first).put(second, values[i]);
            graph.get(second).put(first, 1/values[i]);
        }
        for(int i=0; i<queries.size(); i++) {
            set.clear();
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0);
        }

        return result;
    }

    private double dfs(String start, String end, double num) {
        if(!graph.containsKey(start)) {
            return -1.0;
        }
        if(start.equals(end)) {
            return num;
        }

        set.add(start);
        for (Map.Entry<String, Double> entry : graph.get(start).entrySet()) {
            if(!set.contains(entry.getKey())) {
                double result = dfs(entry.getKey(), end, entry.getValue());
                if(result != -1) {
                    return result * num;
                }
            }
        }

        return -1.0;
    }
}

package _2023년._8월.medium;

import java.util.*;

public class EvaluateDivision {
    HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
    Set<String> set = new HashSet<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        for(int i=0; i<equations.size(); i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);

            graph.putIfAbsent(first, new HashMap<>());
            graph.putIfAbsent(second, new HashMap<>());

            graph.get(first).put(second, values[i]);
            graph.get(second).put(first, 1/values[i]);
        }

        double[] result = new double[queries.size()];

        for(int i=0; i<queries.size(); i++) {
            set.clear();
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0);
        }
        return result;
    }

    private double dfs(String s, String d, double num) {
        if(!graph.containsKey(s))
            return -1.0;
        if(s.equals(d))
            return num;
        set.add(s);

        for (Map.Entry<String, Double> entry : graph.get(s).entrySet()) {
            if(!set.contains(entry.getKey())) {
                double res = dfs(entry.getKey(), d, entry.getValue());
                if(res != -1)
                    return num * res;
            }
        }

        return -1.0;
    }
}

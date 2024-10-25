package _2024년._10월.programmers.lv2;

public class 단체사진_찍기 {
    private int result = 0;
    public int solution(int n, String[] data) {
        String[] names = {"A", "C", "F", "J", "M", "N", "R", "T"};

        dfs("", new boolean[names.length], data, names);

        return result;
    }

    private void dfs(String name, boolean[] visited, String[] data, String[] names) {
        if(name.length() == 8) {
            if(check(name, data)) {
                result++;
            }

            return;
        }

        for(int i=0; i<names.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(name + names[i], visited, data, names);
                visited[i] = false;
            }
        }
    }

    private boolean check(String name, String[] data) {
        for (String d : data) {
            int firstIndex = name.indexOf(d.charAt(0));
            int secondIndex = name.indexOf(d.charAt(2));
            char operation = d.charAt(3);
            int distance = Integer.parseInt(String.valueOf(d.charAt(4)));

            if(operation == '=') {
                if(!(Math.abs(secondIndex - firstIndex) - 1 == distance)) {
                    return false;
                }
            } else if(operation == '<') {
                if(!(Math.abs(secondIndex - firstIndex) - 1 < distance)) {
                    return false;
                }
            } else {
                if(!(Math.abs(secondIndex - firstIndex) - 1 > distance)) {
                    return false;
                }
            }
        }

        return true;
    }
}

package _2023년._8월.medium;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            g.get(prerequisite[1]).add(prerequisite[0]);
        }

        int[] inDegree = new int[numCourses];
        for (List<Integer> dependencies : g) {
            for (int dependency : dependencies) {
                inDegree[dependency]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int cnt = 0;

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            result[cnt++] = poll;

            for (int dependency : g.get(poll)) {
                inDegree[dependency]--;
                if (inDegree[dependency] == 0) {
                    queue.offer(dependency);
                }
            }
        }

        if(cnt == numCourses)
            return result;
        else
            return new int[0];
    }
}

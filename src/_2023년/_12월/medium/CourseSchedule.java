package _2023년._12월.medium;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<inDegree.length; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int remove = queue.remove();
                count++;

                for (int num : graph.get(remove)) {
                    if(--inDegree[num] == 0) {
                        queue.add(num);
                    }
                }
            }
        }

        return count == numCourses;
    }
}

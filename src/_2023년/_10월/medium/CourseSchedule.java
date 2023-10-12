package _2023년._10월.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
            inDegree[prerequisite[1]]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<inDegree.length ;i++) {
            if(inDegree[i]==0)
                deque.add(i);
        }

        int count = 0;
        while(!deque.isEmpty()) {
            int size = deque.size();

            for(int i=0; i<size; i++) {
                int remove = deque.remove();
                count++;

                for(int num : graph.get(remove)) {
                    if(--inDegree[num] == 0) {
                        deque.add(num);
                    }
                }
            }
        }

        return count == numCourses;
    }
}

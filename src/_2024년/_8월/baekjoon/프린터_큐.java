package _2024년._8월.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 프린터_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++) {
            int count = 0;
            Queue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
            Queue<Document> queue = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int importance = Integer.parseInt(st.nextToken());
                queue.add(new Document(j, importance));
                priorityQueue.add(importance);
            }

            while(!queue.isEmpty()) {
                Document remove = queue.remove();

                if(priorityQueue.peek().intValue() == remove.importance) {
                    priorityQueue.remove();
                    count++;

                    if(remove.index == m) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    queue.add(remove);
                }
            }
        }
    }
}

class Document {
    int index;
    int importance;

    public Document(int index, int importance) {
        this.index = index;
        this.importance = importance;
    }
}

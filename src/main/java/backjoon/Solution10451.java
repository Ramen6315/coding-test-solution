package backjoon;

import java.util.LinkedList;
import java.util.Queue;

public class Solution10451 {
    public void main(String[] args) {
        int[] cycle = {2,1,3,4,5,6,7,9,10,8};
        int cnt = 0;
        int[][] graph = new int[cycle.length][cycle.length];
        boolean[] visit = new boolean[cycle.length];

        for (int i = 0; i < cycle.length; i++) {
            graph[i][cycle[i]-1] = 1;
        }
        for (int i = 0; i < cycle.length; i++) {
            if(!visit[i]) {
                cnt += breadth(cycle, graph, visit, i);
                System.out.println(cnt);
            }
        }

        System.out.println(cnt);
    }

    private static int breadth(int[] cycle, int[][] graph, boolean[] visit, int i) {
        int cnt = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visit[i] = true;
        System.out.println(queue);
        while (!queue.isEmpty()) {
            int location = queue.poll();
            for(int j=0; j<cycle.length; j++) {
                if(graph[location][j] == 1 && location == j) {
                    return 1;
                }
                if (graph[location][j] == 1 && !visit[j] ) {
                    cnt++;
                    visit[j] = true;
                    queue.add(j);
                    System.out.println(" + : " + queue);
                }
            }
        }
        if(cnt > 0) {
            return 1;
        }
        return 0;
    }
}

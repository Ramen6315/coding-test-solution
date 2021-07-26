package backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution2606 {
    public void main(String[] args) {
        System.out.println("시작 끝 입력");
        Scanner scanner = new Scanner(System.in);
        int computerCnt = scanner.nextInt();
        int linkCnt = scanner.nextInt();
        int[][] graph = new int[computerCnt][computerCnt];
        boolean[] visit = new boolean[computerCnt];

        for(int i=0; i<linkCnt; i++) {
            System.out.println("시작");
            int start = scanner.nextInt();
            System.out.println("끝");
            int end = scanner.nextInt();
            graph[end-1][start-1] = 1;
            graph[start-1][end-1] = 1;
        }

        System.out.println("바이러스에 걸린 컴퓨터 번호를 적어주세요");
        int virusComputer = scanner.nextInt();
        int cnt = 0;
        breadth(graph, virusComputer, visit);
        for (boolean visited : visit) {
            if(visited) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static int breadth(int[][] graph, int virusComputer, boolean[] visit) {
        int cnt = 0;
        visit[virusComputer-1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(virusComputer);
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for(int i = 0; i<graph.length; i++) {
                if(graph[i][temp - 1] == 1 && !visit[i]) {
                    cnt++;
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }
        return cnt;
    }

    private static int depthR(int[][] graph, boolean[] visit, int virusComputer, int cnt) {
        visit[virusComputer - 1] = true;
        for(int i = 0; i<graph.length; i++) {
            if(graph[i][virusComputer-1] == 1 && visit[i] == false) {
                depthR(graph, visit, i+1, cnt++);
            }
        }
        return 0;
    }
}

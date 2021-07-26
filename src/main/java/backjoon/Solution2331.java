package backjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution2331 {
    public void main(String[] args) {
        int input = 57;
        int p = 2;
        int bound = (int) Math.pow(57, 2);
        int[][] graph = new int[bound][bound];

        List<Integer> bfs = bfs(input, graph, p);
        List<Integer> collect = bfs.stream().distinct().collect(Collectors.toList());
        for (int i = 0; i < collect.size(); i++) {
            int temp = 0;
            for (int j = 1; j < bfs.size(); j++) {
                if (bfs.get(i).equals(bfs.get(j))) {
                    temp++;
                }
                if (temp > 1) {
                    collect.remove(i);
                }
            }
        }
        System.out.println(collect);
        System.out.println(collect.size());
    }

    private static List<Integer> bfs(int input, int[][] graph, int p) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(input);
        List<Integer> same = new ArrayList<>();

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            int nextTarget = calculateTarget(temp, p);

            if (graph[temp][nextTarget] < 2) {
                same.add(temp);
                graph[temp][nextTarget]++;
                queue.add(nextTarget);
            } else if (graph[temp][nextTarget] > 2) {
                break;
            }
        }
        return same;
    }

    private static int calculateTarget(int temp, int p) {
        int result = 0;
        String s = String.valueOf(temp);
        String[] split = s.split("");

        for (String str : split) {
            result += Math.pow(Integer.parseInt(str), p);
        }

        return result;
    }
}

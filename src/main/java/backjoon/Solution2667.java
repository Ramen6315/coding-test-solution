package backjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2667 {
    public void main(String[] args) {
        int[][] arr = {
                {0, 1, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0}
        };
        boolean[][] visit = new boolean[arr.length][arr[0].length];

        List<Integer> house = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1 && !visit[i][j]) {
                    bfs(arr, visit, i, j, house);
                }
            }
        }
        System.out.println(house);
        System.out.println(house.size());
    }

    private static void bfs(int[][] arr, boolean[][] visit, int i, int j, List<Integer> house) {
        int size = 1;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(i, j));
        visit[i][j] = true;
        while(!queue.isEmpty()) {
            Position temp = queue.poll();
            if (temp.x - 1 >= 0 && arr[temp.x - 1][temp.y] == 1 && !visit[temp.x - 1][temp.y]) {
                queue.add(new Position(temp.x - 1, temp.y));
                visit[temp.x - 1][temp.y] = true;
                size += 1;
            }
            if (temp.x + 1 < arr.length && arr[temp.x + 1][temp.y] == 1 && !visit[temp.x + 1][temp.y]) {
                queue.add(new Position(temp.x + 1, temp.y));
                visit[temp.x + 1][temp.y] = true;
                size += 1;
            }
            if (temp.y - 1 >= 0 && arr[temp.x][temp.y - 1] == 1 && !visit[temp.x][temp.y - 1]) {
                queue.add(new Position(temp.x, temp.y - 1));
                visit[temp.x][temp.y - 1] = true;
                size += 1;
            }
            if (temp.y + 1 < arr.length && arr[temp.x][temp.y + 1] == 1 && !visit[temp.x][temp.y + 1]) {
                queue.add(new Position(temp.x, temp.y + 1));
                visit[temp.x][temp.y + 1] = true;
                size += 1;
            }
        }
        house.add(size);
    }

    static class Position {
        int x;
        int y;

        public Position(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }

}

package backjoon;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2468 {
    public static void main(String[] args) {
        int[][] arr = {
                {6, 8, 2, 6, 2},
                {3, 2, 3, 4, 6},
                {6, 7, 3, 3, 2},
                {7, 2, 5, 3, 6},
                {8, 9, 5, 2, 7}
        };
        int boundary = 5;
        boolean[][] visit = new boolean[arr.length][arr[0].length];
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] >= boundary && !visit[i][j]) {
                    bfs(arr, visit, boundary, i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(int[][] arr, boolean[][] visit, int boundary, int i, int j) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(i, j));
        visit[i][j] = true;
        while (!queue.isEmpty()) {
            Position now = queue.poll();
            if (now.x - 1 >= 0 && !visit[now.x - 1][now.y] && arr[now.x - 1][now.y] >= boundary) {
                queue.add(new Position(now.x - 1, now.y));
                visit[now.x-1][now.y] = true;
            }
            if (now.x + 1 < arr.length && !visit[now.x + 1][now.y] && arr[now.x + 1][now.y] >= boundary) {
                queue.add(new Position(now.x + 1, now.y));
                visit[now.x+1][now.y] = true;
            }
            if (now.y - 1 >= 0 && !visit[now.x][now.y - 1] && arr[now.x][now.y - 1] >= boundary) {
                queue.add(new Position(now.x, now.y - 1));
                visit[now.x][now.y - 1] = true;
            }
            if (now.y + 1 < arr.length && !visit[now.x][now.y + 1] && arr[now.x][now.y + 1] >= boundary) {
                queue.add(new Position(now.x, now.y + 1));
                visit[now.x][now.y + 1] = true;
            }
        }
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

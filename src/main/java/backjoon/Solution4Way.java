package backjoon;

import java.util.LinkedList;
import java.util.Queue;

public class Solution4Way {
    final static int endRow = 4;
    final static int endColumn = 6;
    static int[] x = {1, 0, -1, 0};
    static int[] y = {0, 1, 0, -1};

    public void main(String[] args) {
        int[][] miro =
                {
                        {1, 0, 1, 1, 1, 1},
                        {1, 0, 1, 0, 1, 0},
                        {1, 0, 1, 0, 1, 1},
                        {1, 1, 1, 0, 1, 1}
                };
        boolean[][] visit = new boolean[endRow][endColumn];
        depthR(miro, visit, 0, 0);

    }

    // 이방법은 최단 거리 계산을 할 수가 없다.
    private static void depthR(int[][] miro, boolean[][] visit, int currentX, int currnetY) {
        visit[0][0] = true;
        for (int i = 0; i < miro.length; i++) {
            for (int j = 0; j < miro[0].length; j++) {
                System.out.print("|" + miro[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < x.length; i++) {
            int nextX = currentX + x[i];
            int nextY = currnetY + y[i];
            System.out.println(nextX + " : " + nextY);
            if (nextX >= 0 && nextY >= 0 && nextX < 4 && nextY < 6 && !visit[nextX][nextY] && miro[nextX][nextY] == 1) {
                miro[nextX][nextY] = miro[currentX][currnetY] + 1;
                visit[nextX][nextY] = true;
                depthR(miro, visit, nextX, nextY);
            }
        }
    }

    private static void breadth(int[][] miro, boolean[][] visit) {
        int[][] ways = new int[endRow][endColumn];
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0));
        visit[0][0] = true;
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            for (int i = 0; i < endRow; i++) {
                int nextX = current.x + x[i];
                int nextY = current.y + y[i];
                if (nextX < 0 || nextY < 0 || nextX > 3 || nextY > 5) {
                    continue;
                }
                if (visit[nextX][nextY] || miro[nextX][nextY] == 0) {
                    continue;
                }

                queue.add(new Position(nextX, nextY));
                ways[nextX][nextY] = ways[current.x][current.y] + 1;
                visit[nextX][nextY] = true;
            }
        }
        for (int i = 0; i < ways.length; i++) {
            for (int j = 0; j < ways[0].length; j++) {
                System.out.print("|" + ways[i][j] + "|");
            }
            System.out.println();
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

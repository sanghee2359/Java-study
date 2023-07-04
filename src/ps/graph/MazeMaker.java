package ps.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MazeMaker {
    public int longestPath(String[] maze, int startRow, int startCol, int[]moveRow, int[] moveCol) {
        int max = 0;
        int width = maze[0].length(), height = maze.length;
        int[][] board = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = -1;
            }
        }
        board[startRow][startCol] = 0;
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        queueX.add(startCol);
        queueY.add(startRow);

        while(!queueX.isEmpty()){
            int x = queueX.poll(), y = queueY.poll();
            for (int i = 0; i < moveRow.length; i++) {
                int nextX = x + moveCol[i];
                int nextY = y + moveRow[i];
                if(0 <= nextX && nextX < width
                        && 0 <=nextY && nextY < height
                        && board[nextX][nextY] == -1
                        && maze[nextY].charAt(nextX) == '.') {
                    board[nextX][nextY] = board[y][x] +1;
                    queueX.add(nextX);
                    queueY.add(nextY);
                }
            }
        }
    }
}

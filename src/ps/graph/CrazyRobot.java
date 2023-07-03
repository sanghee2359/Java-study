package ps.graph;

import java.util.Scanner;
// 로봇은 각 단계에서 한 방향을 랜덤하게 선택해서 한 칸 움직입니다.
// 로봇이 이동하며 같은 지점을 통과하지 않으면 성공했다고 합니다
public class CrazyRobot {
    boolean[][] grid = new boolean[100][100];
    static int[] vx = {1, -1, 0, 0};
    static int[] vy = {0, 0, 1, -1};
    double[] prob = new double[4];
    public static void main(String[] args) {
        CrazyRobot T = new CrazyRobot();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int east = sc.nextInt();
        int west = sc.nextInt();
        int south = sc.nextInt();
        int north = sc.nextInt();
        System.out.println(T.getProbability(n,east,west,south,north));
    }
    public double getProbability(int n, int east, int west, int south, int north) {
        prob[0] = east / 100.0;
        prob[1] = west / 100.0;
        prob[2] = south / 100.0;
        prob[3] = north / 100.0;
        return dfs(50, 50, n);
    }
    private double dfs(int x, int y, int n) {
        if(grid[x][y]) return 0;
        if(n == 0) return 1;
        grid[x][y] = true;
        double ret = 0;
        for (int i = 0; i < 4; i++) {
            ret += dfs(x+ vx[i], y+ vy[i], n-1)* prob[i];
        }
        grid[x][y] = false;
        return ret;
    }
}

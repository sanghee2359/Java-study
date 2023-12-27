package ps.dfs;

import java.util.Scanner;

public class AdjacentMatrixRoute {
    static int n, m, answer = 0;
    static int[][] graph;
    static int[] visited;
    public void DFS(int v) {
        if(v == n) {
            answer ++;
        }
        else {
            for (int i = v; i <= n; i++) {
                if(graph[v][i] == 1 && visited[i] == 0) {
                    visited[i] = 1;
                    DFS(i);
                    visited[i] = 0; // 탐색이 다 끝나고 pop()할 때 방문 기록을 0 으로 초기화 한다.

                }
            }
        }
    }

    public static void main(String[] args) {
        AdjacentMatrixRoute O = new AdjacentMatrixRoute();
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); // 정점의 수
        m = in.nextInt(); // 간선의 수
        // node를 인덱스로 사용하므로, 1부터 시작
        graph = new int[n+1][n+1];
        visited = new int[n+1];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph[a][b] = 1;
        }
        visited[1] = 1;
        O.DFS(1);
        System.out.println(answer);

    }
}

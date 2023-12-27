package ps.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestRoute {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    static int[] dis;
    public void BFS(int v) {
        Queue<Integer> Q = new LinkedList<>();
        visited[v] = 1;
        Q.offer(v);
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            for (int nv: graph.get(cur)) {
                if(visited[nv] == 0){
                    visited[nv] = 1;
                    Q.offer(nv);
                    dis[nv] = dis[cur]+1;
                }
            }
        }
    }
    public static void main(String[] args) {
        ShortestRoute O = new ShortestRoute();
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); // 정점 개수
        m = in.nextInt(); // 간선 개수
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 방문 체크 배열
        visited = new int[n+1];
        dis = new int[n+1];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
        }
        O.BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i+" : "+dis[i]);
        }
    }
}

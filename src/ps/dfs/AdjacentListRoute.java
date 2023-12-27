package ps.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjacentListRoute {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    public void DFS(int v) {
        if(v == n) answer++;
        else {
            for (int nextV : graph.get(v)) { //v의 다음 정점은 v와 연결된 인접리스트에서 꺼낸다
                if(visited[nextV] == 0){
                    visited[nextV] = 1;
                    DFS(nextV);
                    visited[nextV] = 0;
                }
            }
        }

    }
    public static void main(String[] args) {
        AdjacentListRoute O = new AdjacentListRoute();
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); // 정점의 수
        m = in.nextInt(); // 간선의 수

        // 객체 생성
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 방문 체크 배열
        visited = new int[n+1];
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b); // a의 리스트 객체에 b를 추가
        }
        visited[1] = 1;
        O.DFS(1);
        System.out.println(answer);
    }
}

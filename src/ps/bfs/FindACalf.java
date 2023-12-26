package ps.bfs;
//현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
//현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
//
//송아지는 움직이지 않고 제자리에 있다.
//현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
//
//최소 점프 횟수로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindACalf {
    int[] visited;
    int[] dis = {1, -1, 5};
    public int BFS(int site, int calf){
        int level = 0;
        Queue<Integer> Q = new LinkedList<>();
        visited = new int[10001]; // 최대 : 10000
        visited[site] = 1;
        Q.offer(site);
        while(!Q.isEmpty()){
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int cur = Q.poll();
                for (int j = 0; j < 3; j++) {
                    int next = cur+dis[j];
                    if(next == calf) return level+1;
                    if(next>= 1 && next<= 10000
                            && visited[next]==0){
                        visited[next] = 1;
                        Q.offer(next);
                    }
                }
            }
            level++;
        }
        return level;
    }
    public static void main(String[] args) {
        FindACalf O = new FindACalf();
        Scanner in = new Scanner(System.in);
        int S = in.nextInt(); // 현수의 위치
        int E = in.nextInt(); // 송아지의 위치
        System.out.println(O.BFS(S,E));
    }
}

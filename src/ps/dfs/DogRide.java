package ps.dfs;
// 철수는 그의 바둑이들을 데리고 시장에 가려고 한다.
// 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.
//철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.

import java.util.Scanner;

//N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.
public class DogRide {
    static int n, c, answer= Integer.MIN_VALUE;
    public void DFS(int L, int sum, int[] arr) {
        if(sum > c) return;
        if(L == n) {
            answer = Math.max(answer, sum);
        }
        else {
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }
    public static void main(String[] args) {
        DogRide O = new DogRide();
        Scanner in = new Scanner(System.in);
        c = in.nextInt(); // 트럭 수용 무게
        n = in.nextInt(); // 탑승 시킬 강아지 마리 수
        int[] arr = new int[n]; // 강아지 각각의 무게
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int sum = 0;
        O.DFS(0,sum, arr);
        System.out.println(answer);
    }
}

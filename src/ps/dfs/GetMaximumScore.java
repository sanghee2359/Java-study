package ps.dfs;

import java.util.Scanner;
//현수는 선생님이 주신 N개의 문제를 풀려고 합니다
//각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
//
//제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
//제한시간 안에 얻을 수 있는 최대 점수
public class GetMaximumScore {
    static int n,m, answer = 0;
    public void DFS(int L, int sum, int hour,int[][] arr) {
        if(hour > m) return;
        //최대 점수
        if(L == n) {
            if(answer < sum) {
                answer = sum;
            }
        }
        else {
            // 해당 문제를 풀거나
            DFS(L+1, sum+arr[L][0], hour+arr[L][1], arr);
            // 해당 문제를 풀지 못하거v나
            DFS(L+1, sum, hour, arr);
        }
    }
    public static void main(String[] args) {
        GetMaximumScore O = new GetMaximumScore();
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); // 문제 개수
        m = in.nextInt(); // 제한 시간
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            arr[i][0] = a; // 문제 점수
            arr[i][1] = b; // 걸린 시간
        }
        int hour = 0, sum = 0; // 걸린 시간, 얻은 점수
        O.DFS(0, sum, hour, arr);
        System.out.println(answer);
    }
}

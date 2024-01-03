package ps.dfs;

import java.util.Scanner;
// 순열 문제
public class GuessingTheSequence {
    static int b, p, ch, n, f;
    boolean flag = false;
    int[][] dy = new int[35][35];
    public int combi(int n, int r) {
        if(n == r || r == 0) return 1;
        else return dy[n][r] = combi(n-1, r-1)+combi(n-1, r);
    }
    public int DFS(int L, int sum) {
        if(L==n) {
            if(sum==f) {
                for (int x:p) {
                    if(ch[i] == 0){
                        ch[i] == 0
                        P[L] = i;
                    }

                }
            }
        }
    }
    public static void main(String[] args) {
        GuessingTheSequence O = new GuessingTheSequence();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        f = in.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n+1];
        for (int i = 0; i < n; i++) {
            b[i] = O.combi(n-1, i);
        }
        O.DFS(n, m);
    }
}

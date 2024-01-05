package ps.dfs;

import java.util.Scanner;

public class GetCombination {
    static int[] combi;
    static int n, m;
    public void DFS(int L, int s) {
        if(L==m) {
            for (int x:
                 combi) {
                System.out.println(x+" ");
            }
            System.out.println();
        }
        else {
            for (int i = s; i <= n; i++) {
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }
    public static void main(String[] args) {
        GetCombination O = new GetCombination();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];
        O.DFS(0,1);
    }
}

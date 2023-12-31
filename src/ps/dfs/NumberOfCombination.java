package ps.dfs;

import java.util.Scanner;

// 조합의 경우의 수
// 조합 = 순서를 고려하지 않고 뽑은 경우의 수 (숫자가 중복되지 않으면서 순서와 관계없다)
// nCr = n-1 C r-1 + n-1 C r 공식을 사용하여 조합수를 구하는 프로그램
public class NumberOfCombination {
    static int[][] dy = new int[35][35];
    public int DFS(int n, int r){
        if(dy[n][r] > 0) return dy[n][r];
        if(n == r || r == 0){
            return 1;
        }else {
            return dy[n][r] = DFS(n-1, r-1)+DFS(n-1, r);
        }
    }
    public static void main(String[] args) {
        NumberOfCombination O = new NumberOfCombination();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        System.out.println(O.DFS(n, r));
    }
}

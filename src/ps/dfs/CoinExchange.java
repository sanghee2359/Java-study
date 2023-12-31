package ps.dfs;

import java.util.Scanner;

// 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주는 프로그램
// 동전의 종류 개수 : 1 <= n <= 12
// 거슬러 줄 금액 : 1 <= m <= 500
public class CoinExchange {
    static int n, m, answer = Integer.MAX_VALUE;
    static int[] arr;
    public void DFS(int L, int sum) {
        if(sum > 15) {
            return;
        }
        if(sum == m && L >0) {
            if(answer > L) {
                answer = L;
            }
        }else {
            for (int i = 0; i < n; i++) {
                DFS(L+1, sum+= arr[i]);
                L -= 1;
                sum -= arr[i];
            }
        }
    }
    public static void main(String[] args) {
        CoinExchange O = new CoinExchange();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = n-1; i >= 0; i--) {
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();
        O.DFS(0, 0);
        System.out.println(answer);
    }
}

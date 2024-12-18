package boj.dp;

public class boj_2839 {
    public static void main(String[] args) {
        boj_2839 T = new boj_2839();
        int[][] dp = new int[5000][11];
        dp[0][3] = 1;
        dp[0][5] = 1;
        for (int i = 1; i < 11; i++) {
            if(i % dp[0][3] == 0) dp[0][i] = i/dp[0][3];
            else if(i % dp[0][5] == 0) dp[0][i] = i/dp[0][5];
            else if(i == 8)  dp[0][i] = dp[0][3]+dp[0][5];
        }
    }
}

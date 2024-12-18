package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20546 {
    public int BNP(int cash, int[] MachineDuck) {
        int n = MachineDuck.length;
        int shareOwnership = 0;
        for (int i = 0; i < n; i++) {
            if(cash >= MachineDuck[i]) {
                int shares = cash / MachineDuck[i];
                shareOwnership+= shares;
                cash -= shares * MachineDuck[i];
            }

        }
        return result(cash,MachineDuck[13],shareOwnership);
    }
    public int ThreeThree(int cash, int[] MachineDuck) {
        // 전량 매도 & 전량 매수 전략
        int upCount = 0, downCount = 0;
        int shareOwnership = 0;
        int n = MachineDuck.length;

        for (int i = 0; i < n - 1; i++) {

            // 주가에 따른 조건
            if(MachineDuck[i+1] > MachineDuck[i]) {
                upCount++;
                downCount = 0;
            }
            else if(MachineDuck[i+1] < MachineDuck[i]) {
                downCount++;
                upCount = 0;
            }else {
                upCount = 0;
                downCount = 0;
            }
            // 3일 연속 상승 -> 전량 매도
            if(upCount >= 3 && shareOwnership > 0) {
                cash += MachineDuck[i+1] * shareOwnership;
                shareOwnership = 0;
//                System.out.println(i+2+"일 전량 매도");
            }
            // 3일 연속 하락 -> 전량 매수
            if(downCount >= 3 && cash >= MachineDuck[i + 1]) {
                int maxShares = cash / MachineDuck[i+1];
                shareOwnership += maxShares;
                cash -= maxShares * MachineDuck[i+1]; // 매수할 수 있는 금액만큼
//                System.out.println(i+2+"일 "+maxShares+"주 매수");
            }
        }
        return result(cash, MachineDuck[13], shareOwnership);
    }
    public int result(int cash, int sharePrice, int shareOwnership){
        return cash + (sharePrice * shareOwnership);
    }
    public static void main(String[] args) throws IOException {
        boj_20546 T = new boj_20546();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cash = Integer.parseInt(br.readLine());
        int[] MachineDuck = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 14; i++) {
            MachineDuck[i] = Integer.parseInt(st.nextToken());
        }
        int BNPResult  = T.BNP(cash,MachineDuck);
        int ThreeResult = T.ThreeThree(cash,MachineDuck);
        if(BNPResult > ThreeResult)
            System.out.println("BNP");
        else if(BNPResult < ThreeResult)
            System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
}

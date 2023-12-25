package ps.dfs;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

// 부분집합 구하기
// 집합에 포함하거나 o, 포함하지 않거나 x
public class Subset {
    static int n;
    static int[] ch;
    public void DFS(int L) {// L: 부분집합에 들어갈지 판단 할 숫자
        if(L==n+1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if(ch[i] == 1) tmp+=(i+" ");
            }
            // 공집합이 아니면 출력
            if(tmp.length()>0)System.out.println(tmp);
            return;
        }
        else {
            ch[L] = 1;
            DFS(L+1);
            ch[L] = 0;
            DFS(L+1);

//            System.out.println(L);
        }
    }
    //L index의 값이 0이면 불참, 1이면 참여로 결정
    public static void main(String[] args) {
        Subset O = new Subset();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        ch = new int[n+1];
        O.DFS(1);
    }
}

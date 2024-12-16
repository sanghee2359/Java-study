package boj.implementation;
// S, M, L, XL, XXL, 그리고 XXXL의 6가지 사이즈
// 티셔츠는 같은 사이즈의 T장 묶음으로만 주문
// 펜은 한 종류, P자루씩 묶음 or 한 자루씩 주문

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 티셔츠는 남아도 괜찮지만 부족하면 안된다. 신ㅊㅇ한 사이즈대로 나눠주어야 하고
// 펜은 남아서도 안되고 부족해서도 안된다. 정확히 참가자 수에 맞아야 함.
// 티셔츠를 T장씩 최소 몇 묶음을 주문해야할지
// 펜을 P자루씩 최대 몇 묶음 주문할 수 있고, 그 때 펜을 한 자루씩 몇 개 주문하는지 구한다
public class boj_30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] size = new int[6]; // S, M, XL, XXL, XXXL

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        // input

        int sum = 0;
        // t-shirts
        for (int i = 0; i < 6; i++) {
            int quotient = size[i]/T;
            if(quotient == 0 && (size[i]%T)!= 0) sum += 1;
            else if(quotient >= 1 && (size[i]%T) == 0) sum += quotient;
            else if(quotient >= 1 && (size[i]%T)!= 0) sum += quotient+1;
        }
        System.out.println(sum);
        // pen
        System.out.println(N/P+" "+N%P);
    }
}

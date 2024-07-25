package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 점수 중 최댓값 : M
// 모든 점수 = (점수 / M * 10) 로 수정했다.
// 이때 새로운 평균을 구하는 프로그램 작성하기
public class boj_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        float sum = 0;
        int M = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(M < arr[i]) M = arr[i];
        }
        for (int i = 0; i < num; i++) {
            float tmp = (float)arr[i]/M * 100;
            sum += tmp;
        }
        System.out.println(sum/(float)num);


    }
}

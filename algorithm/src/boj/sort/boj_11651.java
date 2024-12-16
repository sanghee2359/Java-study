package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//  좌표를 y좌표가 증가하는 순으로, y좌표가 같으면
//  x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램
// (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수
public class boj_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
//            System.out.print(arr[i][0]);
            arr[i][1] = Integer.parseInt(st.nextToken());
//            System.out.println(arr[i][1]);
        }
        // 오름차순
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0]; // y가 같으면 x좌표 오름차순
                else return o1[1] - o2[1]; // y좌표 오름차순
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        System.out.println(sb);

    }
}

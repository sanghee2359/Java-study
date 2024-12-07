package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 움직일 때마다 주변 4칸을 모두 살펴야 하는걸까? -> 한칸씩 d(방향)를 변화하며 이동
public class boj_14503 {
    public int solution(int[][] room, int x, int y, int d) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int count = 0;

        while(true) {
            if(room[x][y] == 0) {
                count++; // 현재 칸 청소
                room[x][y] = 2;
            }
             boolean cleaned = false;

            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 반시계 방향 회전
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(room[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    cleaned = true; // 4칸 중 한 칸이라도 빈 칸이 있었는가?
                    break;
                }
            }
            if(!cleaned) {  // 4방향 모두 청소 불가
                int backX = x - dx[d]; // 후진
                int backY = y - dy[d];
                if(room[backX][backY] == 1) break;
                x = backX;
                y = backY;
                // 4칸 중 빈칸이 없는 경우(모두 2 또는 1)
                // -> 후진[방향 d]
                // -> 벽에 막혀 후진도 못하면 종료

            }

        }
        for (int i = 0; i < room.length; i++) {
            System.out.println(Arrays.toString(room[i]));
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        boj_14503 T = new boj_14503();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] room = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(T.solution(room,x,y,d));


    }
}



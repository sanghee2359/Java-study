package boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14503 {
    public int solution(int[][] room, int x, int y, int d) {
        int[] dx = {-1, 0, 1, 0}; // 반시계 방향
        int[] dy = {0, -1, 0, 1};

        int count = 0;

        while(true) {
            if(room[x][y] != 2) {
                count++; // 현재 칸 청소
                room[x][y] = 2;
            }
             boolean flag = false;
            // 주변의 4칸 중 청소되지 않은 빈 칸이 없는 경우
            // 바라보는 방향 유지한 채로 한 칸 후진.
            // 뒤쪽 칸이 벽이라 후진할 수 엇다면 작동 주
            // 4 칸을 다 확인?
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(room[nx][ny] == 0) {
                x = nx;
                y = ny;
                continue;
            }
            // 1로 막혔을 경우 4칸 방향 살펴보기
            for (int i = 1; i < 4; i++) {
                int curDirection = (d + i) % 4;
                nx = x + dx[curDirection];
                ny = y + dy[curDirection];
                if(room[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    d = curDirection;
                    flag = true; // 4칸 중 빈 칸이 있었는가?
                    break;
                }
            }
            if(!flag) {
                nx = x - dy[d]; // 바라본 방향 그대로 한 칸 후진
                ny = y - dx[d];
                if(room[nx][ny] == 1) break;
                x = nx;
                y = ny;
                // 4칸 중 빈칸이 없는 경우(모두 2)
                // -> 후진[방향 d]
                // -> 벽에 막혀 후진도 못하면 종료

            }
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



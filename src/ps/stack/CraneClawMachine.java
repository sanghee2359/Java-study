package ps.stack;
// 게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다. 집어 올린 인형은 바구니에 쌓이게 되는 데,
// 이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다.

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// 조건 1. 만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됩니다.
// 게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때,
// 조건 2. 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 구하는 프로그램을 작성하세요.
public class CraneClawMachine {
    public int solution(int[][] board, int[]moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        // board
        for (int i = 0; i < moves.length; i++) {
            int curIdx = moves[i]-1;
            int curStack = 0;
            if(!basket.isEmpty()) curStack = basket.peek();
            // 위에서부터 검색
            for (int j = 0; j < board.length; j++) {
//                System.out.println(board[j][cur]);
                // 0이 아닌 최상단 값 스택에 넣고, 0으로 교체
                if(board[j][curIdx] != 0) {
                    basket.push(board[j][curIdx]);
                    board[j][curIdx] = 0;

                    break;
                }
                // 모두 0일 경우는?
            }
            System.out.println();
            // 스택의 이전과 같은 번호이면 삭제, 그리고 answer++
            if(basket.peek()==curStack) {
                basket.pop();
                basket.pop();
                answer++;

            }
        }

        return answer;
    }
    static int [][] board;
    public static void main(String[] args) throws IOException {
        CraneClawMachine T = new CraneClawMachine();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }
        System.out.println(T.solution(board, moves));
    }
}

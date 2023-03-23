package ps.array;

// 선생님이 N명의 학생을 일렬로 세웠습니다.
// 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때,
// 맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램

import java.util.Scanner;

public class VisibleStudent {
    public int solution(int n, int[] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]> max) {
                max = arr[i];
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        VisibleStudent T = new VisibleStudent();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(N,arr));
    }
}

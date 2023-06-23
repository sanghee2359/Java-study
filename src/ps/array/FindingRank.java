package ps.array;
// N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램
// 같은 점수가 입력될 경우 높은 등수로 동일 처리
import java.util.Arrays;
import java.util.Scanner;

public class FindingRank {
    public static void main(String[] args) {
        FindingRank T = new FindingRank();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] score = new int[num];
        for (int i = 0; i < num; i++) {
            score[i] = sc.nextInt();
        }
        for(int x : T.solution(num, score)){
            System.out.print(x+" ");
        }
    }

    private int[] solution(int num, int[] score) {
        int answer[] = new int[num];
        // 등수 비교를 어떤걸로 할 것인지
        for (int i = 0; i < score.length; i++) {
            int rank = 1;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < score.length; j++) {
//                if(max == score[j]) {
//                    max = score[j];
//                }else
                if(score[j] > score[i]) {
                    max = score[j];
                    rank++;
                }
            }
            answer[i] = rank;
        }

        return answer;
    }
}

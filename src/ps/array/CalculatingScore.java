package ps.array;
import java.util.Arrays;
import java.util.Scanner;

// 여러 개의 OX 문제로 만들어진 시험에서 연속적으로 답을 맞히는 경우
// 가산점을 주기 위해서 다음과 같이 점수 계산

// 또한, 연속으로 문제의 답이 맞는 경우에서
// 두 번째 문제는 2점, 세 번째 문제는 3점, ..., K번째 문제는 K점
// 시험문제의 채점 결과가 주어졌을 때, 총 점수를 계산하는 프로그램을 작성
public class CalculatingScore {
    public static void main(String[] args) {
        CalculatingScore T = new CalculatingScore();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] result = new int[num+1]; // i와 i+1비교를 위해
        for (int i = 0; i < num; i++) {
            result[i] = sc.nextInt();
        }
        System.out.println(T.solution(num, result));
    }

    private int solution(int num, int[] result) {
        int answer = 0;
        int score[] = new int[num+1];
        int count = 1;
        // i와 i+1 비교
        for (int i = 0; i < num; i++) {
            if(result[i] == result[i+1] && (result[i] == 1)) {
                score[i] = count++;
            }
            else if(result[i] != result[i+1] && result[i]==1){
                score[i] = count;
                count = 1;
            }else { //result[i]==0
                score[i] = 0;
            }
        }
        System.out.println(Arrays.toString(score));
        for (int i = 0; i < score.length; i++) {
            answer += score[i];
        }
        return answer;
    }
}

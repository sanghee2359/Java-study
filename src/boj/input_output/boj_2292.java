package boj.input_output;
//  육각형으로 이루어진 벌집
// 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때
// 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오.
import java.util.Scanner;

// 계속해서 count 별 최대 수용 개수가 6개씩 증가한다.
// 1 = 1 (1) - count : 1
// 2 ~ 7 (5) - count : 2
// 8 ~ 19 (5+6 = 11)
// 20 ~ 37 (5+6+6 = 17)
// 38 ~ 61 (5+6+6+6 = 23)
// 62 ~ 91 (5+6+6+6+6 = 29)
public class boj_2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int plus = 6;
        int capacity = 5;
        int count = 1;
        if(N == 1) {
            System.out.println(count);
            return;
        }
        int max = 2 + capacity;
        for (int i = 2; i <= N; i++) {
            if(i == 2) {
                count++;
            }
            else if(i>max) {
                capacity += plus;
                max = i + capacity;
                count++;
            }
        }

        System.out.println(count);

    }
}

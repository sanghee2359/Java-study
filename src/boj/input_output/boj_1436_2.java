package boj.input_output;
import java.util.Scanner;
// 제일 작은 종말의 수는 666이고, 그 다음으로 큰 수는 1666, 2666, 3666, .... 이다.
// N번째 영화의 제목에 들어간 수를 출력하는 프로그램
//  N은 10,000보다 작거나 같은 자연수이다.

public class boj_1436_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int idx = 0;
        int count = 0;

        for (int i = 666; i < 10000000; i++) {
            int tmp = i;
            count = 0;
            while(tmp!= 0) {
                if (tmp % 10 == 6) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == 3) {
                    idx++;
                    break;
                }
                tmp /= 10;
            }
            if (idx == N) {
                System.out.println(i);
                break;
            }

        }
    }
}

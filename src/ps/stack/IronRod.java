package ps.stack;
// 여러 개의 쇠막대기를 레이저로 절단하려고 한다.
// 효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고,
// 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자른다.

// 조건 1. 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘( ) ’ 으로 표현
// 조건 2. 쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오른쪽 끝은 닫힌 괄호 ‘) ’ 로 표현

import java.util.Scanner;

// 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때,
// 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램
public class IronRod {
    public int solution(String str) {
        int answer = 0;

        return answer;
    }
    public static void main(String[] args) {
        IronRod T = new IronRod();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}

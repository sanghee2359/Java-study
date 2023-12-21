package ps.sort;
// 선생님은 반 학생들에게 반 번호를 정해 주기 위해 운동장에 반 학생들을 키가 가장 작은 학생부터 일렬로 키순으로 세웠습니다.
// 제일 앞에 가장 작은 학생부터 반 번호를 1번부터 N번까지 부여합니다. 철수는 짝꿍보다 키가 큽니다.
// 그런데 철수가 앞 번호를 받고 싶어 짝꿍과 자리를 바꿨습니다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 철수와 짝꿍이 자리를 바꾼 반 학생들의 일렬로 서있는 키 정보가 주어질 때 철수가 받은 번호와 철수 짝꿍이 받은 번호를
// 차례로 출력하는 프로그램을 작성하세요.
//출력해설 : 키 정보 152가 철수이고, 127이 철수 짝꿍입니다.
public class Mischief {
    private ArrayList Numbering(int num, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone(); // 배열 복사
        Arrays.sort(tmp);

        for (int i = 0; i < num; i++) {
            if(arr[i] != tmp[i]) answer.add(i+1);
        }
        return answer;
    }
    public static void main(String[] args) {
        Mischief O = new Mischief();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = in.nextInt();
        }
        for (Object x: O.Numbering(num, arr)) {
            System.out.printf(x+" ");
        }
    }
}

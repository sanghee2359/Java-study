package ps.sort;

import java.util.Scanner;

public class CheckDuplication {
    // 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D, 각자 다르면 U를 출력
    private char Check(int[] arr) {
        char answer = 'U';
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]==arr[j]) answer = 'D';
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        CheckDuplication O = new CheckDuplication();
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(O.Check(arr));

    }
}

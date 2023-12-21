package ps.sort;

import java.util.Arrays;
import java.util.Scanner;

public class CheckDuplication {
    // 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D, 각자 다르면 U를 출력
    private String Check(int[] arr) {
        String answer = "U";
        // 정렬 후 비교
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-1; i++) {
            System.out.println("i:"+arr[i]+", i+1:"+arr[i+1]);
            if(arr[i] == arr[i+1]) answer = "D";
        }
        for (int x:
             arr) {
            System.out.printf(x+" ");
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

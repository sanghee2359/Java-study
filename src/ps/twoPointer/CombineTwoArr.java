package ps.twoPointer;
// 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램
// 투 포인터는 어떻게 해야할까
import java.util.ArrayList;
import java.util.Scanner;

public class CombineTwoArr {
    public ArrayList<Integer> solution(int[]arr1, int[]arr2){
        ArrayList<Integer> answer = new ArrayList<>();
        int a1P = 0, a2P = 0;
        // 둘 중 하나라도 포인터가 배열 크기보다 넘어서면 종료
        while(a1P<arr1.length && a2P<arr2.length){
            if(arr1[a1P]>arr2[a2P]) {
                answer.add(arr2[a2P++]);
            }else answer.add(arr1[a1P++]);
        }
        // 남은 원소 넣어주기
        while(a1P<arr1.length) answer.add(arr1[a1P++]);
        while(a2P<arr2.length) answer.add(arr2[a2P++]);
        return answer;
    }
    public static void main(String[] args) {
        CombineTwoArr T = new CombineTwoArr();
        Scanner sc = new Scanner(System.in);
        // input
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }
        // result
        for(int x : T.solution(arr1, arr2)){
            System.out.printf(x+" ");
        }
    }
}

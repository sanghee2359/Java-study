package ps.twoPointer;
// A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CommonElements {
    public ArrayList<Integer> solution(int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 정렬
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1=0, p2=0;
        // 반복문 두 배열이 끝날 때까지 반복
        while(p1<arr1.length && p2<arr2.length){
            if(arr1[p1]<arr2[p2]) p1++;
            else if(arr1[p1]==arr2[p2]) {
                answer.add(arr1[p1]);
                p1++;
                p2++;
            }
            else p2++;
        }

        return answer;
    }
    public static void main(String[] args) {
        CommonElements T = new CommonElements();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }
        for (int x:
             T.solution(arr1, arr2)) {
            System.out.printf(x+" ");
        }
    }
}

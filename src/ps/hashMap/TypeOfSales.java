package ps.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// 제과점에서 N일 동안의 매출기록을 주고, 연속된 K일 동안의 매출액의 종류를 각 구간별로 구하라
// N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별 매출액의 종류를 출력하는 프로그램
public class TypeOfSales {
    public ArrayList<Integer> solution(int k, int[] record) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> section = new HashMap<>();
        int a = 0;
        for (int i = 0; i < k; i++) { // k개의 구간
            section = new HashMap<>(); // hash map reset
            for (int j = 0; j < k; j++) { // k연속
                section.put(record[j+a],section.getOrDefault(record[j+a], 0)+1);
            }
            answer.add(section.size());
            a++; // 인덱스를 한 칸씩 옮겨서 값을 저장하는 역할
        }
        return answer;
    }
    public static void main(String[] args) {
        TypeOfSales T = new TypeOfSales();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // n일
        int K = sc.nextInt(); // 연속된 k일
        int[] record = new int[N];
        for (int i = 0; i < record.length; i++) {
            record[i] = sc.nextInt();
        }
        for(int x : T.solution(K, record)){
            System.out.printf(x+" ");
        }
    }
}

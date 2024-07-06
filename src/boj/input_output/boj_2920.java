package boj.input_output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// c d e f g a b C, 총 8개 음으로 이루어져있다.
// c는 1로, d는 2로, ..., C를 8
// 1부터 8까지 차례대로 연주한다면 ascending,
// 8부터 1까지 차례대로 연주한다면 descending,
// 둘 다 아니라면 mixed
public class boj_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        int[] ascending = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] descending = {8, 7, 6, 5, 4, 3, 2, 1};
        String[] input = br.readLine().split(" ");
        boolean isAsc = true;
        boolean isDesc = true;
        for (int i = 0; i < input.length; i++) {
            if(isAsc && Integer.parseInt(input[i]) != ascending[i]) isAsc = false;

            if(isDesc && Integer.parseInt(input[i]) != descending[i]) isDesc = false;
        }
        if(!isAsc && !isDesc) System.out.println("mixed");
        else if(isDesc) System.out.println("descending");
        else if(isAsc) System.out.println("ascending");
    }
}

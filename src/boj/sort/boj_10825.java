package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// 도현이네 반의 학생의 수 N (1 ≤ N ≤ 100,000)이 주어진다.
// 둘째 줄부터 한 줄에 하나씩 각 학생의 이름, 국어, 영어, 수학 점수가 공백으로 구분해 주어진다
// 문제에 나와있는 정렬 기준으로 정렬한 후 첫째 줄부터 N개의 줄에 걸쳐 각 학생의 이름을 출력한다.
public class boj_10825 {
    //1. 국어 점수가 감소하는 순서로
    //2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
    //3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
    //4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
    // (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Classmate [] arr = new Classmate[N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int k = Integer.parseInt(str[1]);
            int e = Integer.parseInt(str[2]);
            int m = Integer.parseInt(str[3]);
            arr[i] = new Classmate(str[0], k, e, m);
        }
        Arrays.sort(arr, new Comparator<Classmate>() {
            @Override
            public int compare(Classmate o1, Classmate o2) {
                if(o1.korScore == o2.korScore
                        && o1.mathScore == o2.mathScore
                        && o1.engScore == o2.engScore) return o1.name.compareTo(o2.name);
                else if(o1.korScore == o2.korScore
                        &&o1.engScore == o2.engScore) return o2.mathScore - o1.mathScore;
                else if(o1.korScore == o2.korScore) return o1.engScore - o2.engScore;
                else return o2.korScore - o1.korScore;
            }
        });
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}
class Classmate {
    String name;
    int korScore;
    int engScore;
    int mathScore;

    public Classmate(String name, int korScore, int engScore, int mathScore) {
        this.name = name;
        this.korScore = korScore;
        this.mathScore = mathScore;
        this.engScore = engScore;
    }

    @Override
    public String toString() {
        return name;
    }
}

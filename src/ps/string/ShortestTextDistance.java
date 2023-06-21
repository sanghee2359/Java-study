package ps.string;

// 한 개의 문자열 s와 문자 t가 주어지면
// 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램

import java.util.Scanner;

public class ShortestTextDistance {
    public int[] solution(String s, char t) {
        int [] answer = new int[s.length()];
        int P = 1000;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==t){
                P = 0;
                answer[i] = P;
            }
            else {
                P++;
                answer[i] = P;
            }
        }
        P = 1000;
        for (int i = s.length()-1; i >= 0 ; i--) {
            if(s.charAt(i) == t) {
                P = 0;
            }else {
                P++;
                answer[i] = Math.min(answer[i], P);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        ShortestTextDistance T = new ShortestTextDistance();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char t = sc.next().charAt(0);
        for(int x : T.solution(s,t)){
            System.out.printf(x+" ");
        }
    }
}

package ps.string;
// 특정 문자가 문자열에 몇 개 존재하는지 알아내는 프로그램

import java.util.Scanner;

public class FindLetter {
    public int solution(String str, char c) {
        int answer = 0;
        // lowercase
        str = str.toLowerCase();
        c = Character.toLowerCase(c);

        // 값 비교
        for(char x : str.toCharArray()){
            if(x==c) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FindLetter T = new FindLetter();
        String str = sc.nextLine();
        char c = sc.next().charAt(0);
        System.out.println(T.solution(str, c));
    }
}
